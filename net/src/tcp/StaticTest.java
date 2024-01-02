package tcp;

import java.net.Socket;
import java.util.ArrayList;

import static tcp.Test.arrayList;
public class StaticTest {
    public static void main(String[] args) {
        ArrayList<String> strings = Test.getArrayList();
        for (String string : strings) {
            System.out.println(string);
        }
    }
}

