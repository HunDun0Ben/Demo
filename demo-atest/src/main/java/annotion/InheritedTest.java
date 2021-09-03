package annotion;

import java.lang.annotation.*;

public class InheritedTest {
    public static void main(String[] args){
        ParentClass parent = new ParentClass();
        SunClass sun = new SunClass();
        InheritedSunClass inSun = new InheritedSunClass();

        for (Annotation annotation : parent.getClass().getAnnotations()) {
            System.out.println(parent.getClass().getName() + ": annotation " + annotation.getClass() + ": value " + annotation);
        }

        for (Annotation annotation : sun.getClass().getAnnotations()) {
            System.out.println(sun.getClass().getName() + ": annotation " + annotation.getClass() + ": value " + annotation);
        }

        for (Annotation annotation : inSun.getClass().getAnnotations()) {
            System.out.println(inSun.getClass().getName() + ": annotation " + annotation.getClass() + ": value " + annotation);
        }
        Class parentC = ((ParentClass)inSun).getClass();
        for (Annotation annotation : parentC.getAnnotations()) {
            System.out.println(parentC.getName() + "Pare + C : annotation " + annotation.getClass() + ": value " + annotation);
            parentC = inSun.getClass().getSuperclass();
            for (Annotation tt : parentC.getAnnotations()) {
                System.out.println(inSun.getClass().getName() + ": annotation " + tt.getClass() + ": value " + tt);
            }
        }
    }
}

@Target( { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface InheritedT {
    String[] value() default "InheritedT";
}

@InheritedT(value = "ParentClass")
class ParentClass {

}


class SunClass extends ParentClass {

}

@InheritedT(value = "InheritedSunClass")
class InheritedSunClass extends ParentClass {

}
