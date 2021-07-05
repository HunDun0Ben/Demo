package design.model;

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Event {

}

interface Publish {
    List<Subscribe> registerSub(Subscribe sub);
    void removeSub(Subscribe sub);
    void publishMessage();
}


interface Subscribe {
    void handleMessage(String msg);
}

public class PubSubModel {
    public static void main(String[] args) {
        EventPublish publish = new EventPublish();
        Subscribe sub1 = new EventSubscribe("EventSubscribe`1");
        Subscribe sub2 = new EventSubscribe("EventSubscribe`2");
        publish.registerSub(sub1).add(sub2);
        publish.publishMessage();
    }
}

class EventPublish implements Publish {

    private final List<Subscribe> registerList = new ArrayList<>();

    @Override
    public List<Subscribe> registerSub(Subscribe sub) {
        registerList.add(sub);
        return registerList;
    }

    @Override
    public void removeSub(Subscribe sub) {
        registerList.remove(sub);
    }

    @Override
    public void publishMessage() {
        String msg = new String("message");
        registerList.forEach(subscribe -> {
            subscribe.handleMessage(msg);
        });
    }
}

class EventSubscribe implements Subscribe {

    private final String name;

    public EventSubscribe(String name) {
        this.name = name;
    }

    @Override
    public void handleMessage(String msg) {
        System.out.println("name:" + name + ", ");
    }
}
