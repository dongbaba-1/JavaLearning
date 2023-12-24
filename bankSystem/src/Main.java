class MyClass {
    int value;

    MyClass(int value) {
        this.value = value;
    }
}

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass(10);
        modifyObject(obj);
        System.out.println("Value after modifying: " + obj.value);

        reassignObject(obj);
        System.out.println("Value after reassigning: " + obj.value);
    }

    // 修改对象属性
    static void modifyObject(MyClass obj) {
        obj.value = 20;
    }

    // 重新赋值参数
    static void reassignObject(MyClass obj) {
        obj = new MyClass(30);
    }

}

