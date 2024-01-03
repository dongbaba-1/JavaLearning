package proxy;

public class BigStar implements Star{
    private String name;

    public BigStar(String name) {
        this.name = name;
    }

    public String sing(String songName){
        System.out.println(this.name + "正在唱"+ songName);
        return "xiexie";
    }

    public void dance(){
        System.out.println(this.name + "正在跳舞");
    }
}
