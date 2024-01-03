package reflection;

import org.junit.Test;

import java.lang.reflect.Constructor;

public class Test2Constructor {
    @Test
    public void testGetConstructor() throws Exception {
        Class c1 = Student.class;
        //Constructor[] constructors = c1.getConstructors();
        Constructor[] constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName()+"--->" +constructor.getParameterCount());
        }
        //Constructor constructor1 = c1.getConstructor();
        Constructor constructor1 = c1.getDeclaredConstructor();
        //System.out.println(constructor1.getName()+"--->" +constructor1.getParameterCount());

        Constructor constructor2 = c1.getDeclaredConstructor(String.class,int.class);//获取有参构造

        //获取构造器后还是用于初始化新对象
        Student student = (Student) constructor2.newInstance("asda",18);
        System.out.println(student);

        //暴力反射，破坏封装
        constructor1.setAccessible(true);
        Student student2 = (Student) constructor1.newInstance();
        System.out.println(student2);


    }
}
