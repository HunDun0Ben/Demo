package design.model.event.bus;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.concurrent.*;

public class PubSubEventBus {
    public static void main(String[] args) {
        EventBus bus = new EventBus();
        bus.register(new HelloWorld());
        bus.post(EventType.HELLO);
        bus.post("Hundun");
    }
}

enum EventType {
    HELLO, GOODBYE;
}

class HelloWorld {
    @Subscribe(type = EventType.HELLO)
    public void hello(String msg) {
        System.out.println("Hello, " + msg);
    }

    @Subscribe(type = EventType.GOODBYE)
    public void hello(EventType type) {
        System.out.println(type.name() + "Hello");
    }

}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Subscribe {
    EventType type();
}

// 相当于订阅者
class ObserverAction {

    private Object target;
    private Method method;

    public ObserverAction(Object target, Method method) {
        this.target = Optional.of(target).get();
        this.method = method;
        this.method.setAccessible(true);
    }

    public void execute(Object event) {
        try {
            method.invoke(target, event);
        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

class ObserverRegistry {

    private ConcurrentMap<Class<?>, CopyOnWriteArraySet<ObserverAction>> registry = new ConcurrentHashMap<>();

    public void register(Object observer) {
        Map<Class<?>, Collection<ObserverAction>> observerActions = findAllObserverActions(observer);
        observerActions.forEach((k, v) -> {
            CopyOnWriteArraySet<ObserverAction> registerEventAction = registry.get(k);
            if (registerEventAction == null) {
                registry.putIfAbsent(k, new CopyOnWriteArraySet<>());
                registerEventAction = registry.get(k);
            }
            registerEventAction.addAll(v);
        });
    }

    public List<ObserverAction> getMatchedObserverActions(Object event) {
        List<ObserverAction> matchedObservers = new ArrayList<>();
        Class<?> postedEventType = event.getClass();
        registry.forEach((k, v) -> {
            if (postedEventType.isAssignableFrom(k)) {
                matchedObservers.addAll(v);
            }
        });
        return matchedObservers;
    }

    private Map<Class<?>, Collection<ObserverAction>> findAllObserverActions(Object observer) {
        // event, ObserverAction
        Map<Class<?>, Collection<ObserverAction>> observerActions = new HashMap<>();
        Class<?> clazz = observer.getClass();
        for (Method method : getAnnotatedMethods(clazz)) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            // 参数含有 eventType
            Class<?> eventType = parameterTypes[0];
            if (!observerActions.containsKey(eventType)) {
                observerActions.put(eventType, new ArrayList<>());
            }
            observerActions.get(eventType).add(new ObserverAction(observer, method));
        }
        return observerActions;
    }

    // 返回 @subscribe 修饰的方法
    private List<Method> getAnnotatedMethods(Class<?> clazz) {
        List<Method> annotatedMethods = new ArrayList<>();
        // 获取本身 Class 定义的所有方法。 不包括继承的方法。
        for (Method method : clazz.getDeclaredMethods()) {
            // 判断方法是否有 @Subscribe 修饰
            if (method.isAnnotationPresent(Subscribe.class)) {
                // 获得方法的参数
                Class<?>[] parameterTypes = method.getParameterTypes();
                // check 操作， 省略。
                annotatedMethods.add(method);
            }
        }
        return annotatedMethods;
    }
}

class EventBus {
    private Executor executor;
    private ObserverRegistry registry = new ObserverRegistry();

    public EventBus() {
        this(Executors.newSingleThreadExecutor());
    }

    public EventBus(Executor executor) {
        this.executor = executor;
    }

    public void register(Object object) {
        registry.register(object);
    }

    public void post(Object event) {
        List<ObserverAction> observerActions = registry.getMatchedObserverActions(event);
        for (ObserverAction action : observerActions) {
            executor.execute(() -> action.execute(event));
        }
    }
}

class AsyncEventBus extends EventBus {
    public AsyncEventBus(Executor executor) {
        super(executor);
    }
}