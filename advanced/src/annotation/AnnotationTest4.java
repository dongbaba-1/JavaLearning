package annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest4 {

    @MyTest
    public void test1(){
        System.out.println("-----test1------");
    }

    //@MyTest
    public void test2(){
        System.out.println("-----test2------");
    }

    @MyTest
    public void test3(){
        System.out.println("-----test3------");
    }
    //@MyTest
    public void test4(){
        System.out.println("-----test4------");
    }
    @MyTest
    public void test5(){
        System.out.println("-----test5------");
    }

    public static void main(String[] args) throws Exception {
        Class c = AnnotationTest4.class;
        Method[] methods= c.getDeclaredMethods();

        for (Method method : methods) {
            //若有注解,则执行
            //System.out.println(method.getName());
            if(method.isAnnotationPresent(MyTest.class)){
                method.invoke(new AnnotationTest4());
            }
        }
    }
}
