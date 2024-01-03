package annotation;

@MyTest4(value = "类上注解", bbb = {"111","2"})
public class Demo {
    @MyTest4(value = "方法上注解",aaa = 200,bbb = {"222","你"})
    public void test1(){

    }
}
