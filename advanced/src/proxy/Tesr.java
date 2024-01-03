package proxy;

public class Tesr {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("A");
        Star starProxy = ProxyUtil.createProxy(bigStar);

        System.out.println(starProxy.sing("好运来"));

        starProxy.dance();
    }
}
