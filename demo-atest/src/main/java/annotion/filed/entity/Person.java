package annotion.filed.entity;

import annotion.filed.annotion.Sensitive;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Person {

    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Sensitive
    private String id;

    private String name;

    @Sensitive
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
