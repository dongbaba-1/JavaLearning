package tcp;

import java.util.ArrayList;

public class Test {
    public static ArrayList<String> arrayList= new ArrayList<>();


    // 静态代码块，在类加载时执行
    static {
        arrayList.add("aaaa");
        arrayList.add("111");
        //System.out.println(arrayList.size());
    }
    public static void main(String[] args) {
//        arrayList.add("aaaa");
//        arrayList.add("111");
//        System.out.println(arrayList.size());
        while(true){
        }
    }

    public static ArrayList<String> getArrayList() {
        return arrayList;
    }
}
