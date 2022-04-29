package annotion.filed.util;

import lombok.extern.slf4j.Slf4j;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class SensitiveFieldUtil {

    private static final Map<Field, Method> GET_METHOD = new ConcurrentHashMap<>();
    private static final Map<Field, Method> SET_METHOD = new ConcurrentHashMap<>();

    public static <T, K extends Annotation> void encryptFields(T obj, Class<?> cls, Class<K> annotation) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        processFields(obj, cls, annotation, true);
    }

    public static <T, K extends Annotation> void decryptFields(T obj, Class<?> cls, Class<K> annotation) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        processFields(obj, cls, annotation, false);
    }

    public static <T, K extends Annotation> void processFields(T obj, Class<?> cls, Class<K> annotation, boolean encrypt) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Field[] fields = cls.getDeclaredFields();
        //
        Class superclass = cls.getSuperclass();
        if(superclass != Object.class) {
            processFields(obj, superclass, annotation, encrypt);
        }
        if (fields.length == 0) {
            return;
        }
        for (Field field : fields) {
            // if properties type is List.class
            if (field.getType().isAssignableFrom(List.class)) {
                ParameterizedType pt = (ParameterizedType) field.getGenericType();
                Class gtCls = (Class) pt.getActualTypeArguments()[0];
                List<?> values = (List<?>) getFieldValue(field, obj);
                if (values != null) {
                    if (gtCls == String.class) {
                        if (field.getAnnotation(annotation) != null) {
                            List<String> newList = new ArrayList<>();
                            for (Object ele : values) {
                                newList.add((String) processData(ele, encrypt));
                            }
                            setFieldValue(field, obj, newList);
                        }
                    } else {
                        for (Object ele : values) {
                            processFields(ele, gtCls, annotation, encrypt);
                        }
                    }
                }
            } else {
                if (field.getAnnotation(annotation) != null) {
                    Object data = getFieldValue(field, obj);
                    if(data.getClass() == String.class) {
                        setFieldValue(field, obj, processData(data, encrypt));
                    } else {
                        processFields(data, data.getClass(), annotation, encrypt);
                    }
                }
            }
        }
    }


    public static Object getFieldValue(Field field, Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Method method = GET_METHOD.get(field);
        if(method == null) {
            synchronized (GET_METHOD) {
                method = GET_METHOD.get(field);
                if(method == null) {
                    PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), obj.getClass());
                    method = descriptor.getReadMethod();
                    GET_METHOD.put(field, method);
                }
            }
        }
        return method.invoke(obj);
    }

    public static void setFieldValue(Field field, Object obj, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Method method = SET_METHOD.get(field);
        if(method == null) {
            synchronized (SET_METHOD) {
                method = SET_METHOD.get(field);
                if(method == null) {
                    PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), obj.getClass());
                    method = descriptor.getWriteMethod();
                    SET_METHOD.put(field, method);
                }
            }
        }
        method.invoke(obj, value);
    }

    private static Object processData(Object data, boolean encrypt) {
        return encrypt ? encryptData(data) : decryptData(data);
    }

    private static Object encryptData(Object data) {
        if (data == null) {
            return null;
        }
        if (data.getClass() == String.class) {
            return String.valueOf(UXDESEncryptDecrypt.encryptData(data.toString()));
        }
        return data;
    }

    private static Object decryptData(Object data) {
        if (data == null) {
            return null;
        }
        if (data.getClass() == String.class) {
            return String.valueOf(UXDESEncryptDecrypt.decryptData(data.toString()));
        }
        return data;
    }
}

@Slf4j
class UXDESEncryptDecrypt {

    public static String encryptData(String data) {
        log.info("Encrypt Data {}", data);
        return data + "Encrypt";
    }

    public static String decryptData(String data) {
        log.info("Decrypt Data {}", data);
        return data + "Decrypt";
    }
}