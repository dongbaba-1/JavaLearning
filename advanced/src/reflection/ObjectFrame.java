package reflection;

import java.io.*;
import java.lang.reflect.Field;

public class ObjectFrame {
//    private Class c;
//    private Object object;
//    public ObjectFrame(Object obj){
//        Class c = obj.getClass();
//        this.c = c;
//        this.object = obj;
//    }

//    public String getValue() throws Exception {
//        Field[] fields = c.getDeclaredFields();
//        StringBuilder buffer = null;
//        for (Field field : fields) {
//            field f = (field)field.get(object);
//            buffer.append(o.toString() + " \n");
//        }
//        String result = buffer.toString();
//        return result;
//    }
//
//    public void write(){
//        try(BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true))) {
//            String data = getValue();
//            writer.write(data + "111");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    public static void saveObject(Object obj) throws Exception {

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt",true));
        Class c = obj.getClass();
        
        Field[] fields = c.getDeclaredFields();

        for (Field field : fields) {
            //获取变量字段名
            String name = field.getName();
            //获取变量值
            field.setAccessible(true);
            String value = (String) field.get(obj);
            System.out.println(name + value);
            writer.write("\n" + name + value + "\n");
        }
        writer.close();
    }
}
