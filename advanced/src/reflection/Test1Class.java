package reflection;

import java.lang.reflect.Constructor;

public class Test1Class {
    public static void main(String[] args) throws Exception {
        //获取Class对象的三种方式
        //1、
        Class c1 = Student.class;
        System.out.println(c1.getName());

        //2、
        Class c2 = Class.forName("reflection.Student");

        //3、
        //Student student = new Student();
        //Class c3 = student.getClass();

        //Constructor constructor = c1.getConstructor();

    }
}
