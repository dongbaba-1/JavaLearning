package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest3 {
    public static void main(String[] args) throws Exception {
        //获取类对象
        Class c = Demo.class;
        //通过类对象获取方法对象
        Method method = c.getDeclaredMethod("test1");

        //解析类上的注解
//        Annotation[] annotationsClass = c.getDeclaredAnnotations();
//        Annotation annotationMethod = method.getDeclaredAnnotation(MyTest4.class);
//
//        System.out.println(annotationMethod.toString());
        if(c.isAnnotationPresent(MyTest4.class)){
            MyTest4 myTest4 = (MyTest4) c.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.value());
            System.out.println(myTest4.aaa());
            System.out.println(Arrays.toString(myTest4.bbb()));

        }

        //解释方法上的注解
        if(method.isAnnotationPresent(MyTest4.class)){
            MyTest4 myTest4 = method.getDeclaredAnnotation(MyTest4.class);
            System.out.println(myTest4.aaa());
            System.out.println(myTest4.value());
        }


    }
}
