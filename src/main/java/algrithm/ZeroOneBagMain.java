package algrithm;

public class ZeroOneBagMain {

    public static void main(String[] args) {
        ZeroOneBagRecall zeroOneBagRecall = new ZeroOneBagRecall();
        zeroOneBagRecall.recall(0, 0);
        System.out.println(zeroOneBagRecall.maxW);
    }
}
