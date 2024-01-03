package reflection;

public class TestObjectFrame {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("小王",15);
        Student s2 = new Student("小s",12);
        Student s3 = new Student("小2",11);

        Cat c1 = new Cat("tom","蓝猫");
        Cat c2 = new Cat("james","金渐层");

        ObjectFrame.saveObject(c1);
        ObjectFrame.saveObject(c2);
    }
}




