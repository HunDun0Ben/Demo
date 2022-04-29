package annotion.filed;

import annotion.filed.annotion.Sensitive;
import annotion.filed.entity.Student;
import annotion.filed.util.SensitiveFieldUtil;
import lombok.extern.slf4j.Slf4j;
import util.TimerUtil;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class EnrollProcess {

    public static final Map<Field, Method> GET_METHOD = new ConcurrentHashMap<>();
    public static final Map<Field, Method> SET_METHOD = new ConcurrentHashMap<>();

    public static void main(String[] args) throws Exception {
        Student student = new Student();
        student.setAge(12);
        student.setId("id" + "student");
        student.setName("name" + 1);
        TimerUtil.startTimer();
        log.error("Student name = {}, id = {}", student.getName(), student.getId());
        SensitiveFieldUtil.processFields(student, Student.class, Sensitive.class, true);
        long ms = TimerUtil.stopTimer();
        log.error("all spend time = {}ms", ms);

        TimerUtil.startTimer();
        SensitiveFieldUtil.processFields(student, Student.class, Sensitive.class, true);
        long sms = TimerUtil.stopTimer();
        log.error("all spend time = {}ms", sms);
        log.error("all result: {}", student);
        log.error("Student name = {}, id = {}", student.getName(), student.getId());

        while (true) {
            Thread.sleep(10000);
        }
    }

    public static int encrypt(String str) {
        log.debug("result = {}", str.hashCode());
        return str.hashCode();
    }

    public static <T, K extends Annotation> void processFields(T obj, Class<T> cls, Class<K> annotation) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Field[] fields = cls.getDeclaredFields();

        Class superclass = cls.getSuperclass();
        if(superclass != Object.class) {
            processFields(obj, superclass, annotation);
        }

        if (fields.length == 0) {
            return;
        }
        for (Field field : fields) {
            if (field.getType().isAssignableFrom(List.class)) {
                ParameterizedType pt = (ParameterizedType) field.getGenericType();
                Class gtCls = (Class) pt.getActualTypeArguments()[0];
                List<?> values = (List<?>) getFieldValue(field, obj);
                if (values != null) {
                    for (Object ele : values) {
                        processFields(ele, gtCls, annotation);
                    }
                }
            } else {
                if (field.getAnnotation(annotation) != null) {
                    Object data = getFieldValue(field, obj);
                    Object result = setFieldValue(field, obj, encryptData(data));
                }
            }
        }

    }


    public static Object getFieldValue(Field field, Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        TimerUtil.startTimer("get");
        Method method = GET_METHOD.get(field);
        if (method == null) {
            synchronized (GET_METHOD) {
                method = GET_METHOD.get(field);
                if (method == null) {
                    PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), obj.getClass());
                    method = descriptor.getReadMethod();
                    GET_METHOD.put(field, method);
                }
            }
        }
        long get = TimerUtil.getTimer("get");
        Object res = method.invoke(obj);
        long invoke = TimerUtil.getTimer("get");
        log.debug("Filed={}, class={}, Get&Invoke Descriptor spend={}ms, invoke spend={}ms", field.getName(), field.getType().getTypeName(), get, invoke - get);
        return res;
    }

    public static Object setFieldValue(Field field, Object obj, Object value) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        TimerUtil.startTimer("set");
        Method method = SET_METHOD.get(field);
        if (method == null) {
            synchronized (SET_METHOD) {
                method = SET_METHOD.get(field);
                if (method == null) {
                    PropertyDescriptor descriptor = new PropertyDescriptor(field.getName(), obj.getClass());
                    method = descriptor.getWriteMethod();
                    SET_METHOD.put(field, method);
                }
            }
        }
        long set = TimerUtil.getTimer("set");
        Object res = method.invoke(obj, value);
        long invoke = TimerUtil.getTimer("set");
        log.debug("Filed={}, class={}, Get&Invoke Descriptor spend={}ms, invoke spend={}ms", field.getName(), field.getType().getTypeName(), set, invoke - set);
        return res;
    }

    public static Object encryptData(Object data) {
        if (data == null) {
            return null;
        }

        if (data.getClass() == String.class) {
            return String.valueOf(encrypt(data.toString()));
        }
        if (data.getClass() == Integer.class) {
            return encrypt(String.valueOf(data));
        }
        return null;
    }
}


