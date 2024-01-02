package tcp;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static ArrayList<String> arrayList= new ArrayList<>();
    public static int Num;

    public static void main(String[] args) {
        arrayList.add("aaaa");
        arrayList.add("111");
        System.out.println(arrayList.size());
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("输入一个加数");
            int temp = sc.nextInt();
            Num += temp;
            System.out.println(Num);
        }
    }

    public static ArrayList<String> getArrayList() {
        return arrayList;
    }

    public static int getNum() {
        return Num;
    }
}
