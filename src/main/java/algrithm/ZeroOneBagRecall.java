package algrithm;

public class ZeroOneBagRecall {
    public static int maxW = Integer.MIN_VALUE;
    private static int[] weight = {2,2,4,6,3};
    private static int n = 5;
    private static int w = 9;

    public static void recall(int i, int curW){
        if(curW == w || i==n){
            if(curW > maxW){
                maxW = curW;
            }
            return;
        }
        recall(i+1, curW);
        if(curW + weight[i] <= w){
            recall(i+1, curW + weight[i]);
        }
    }

    public static void main(String[] args) {
        recall(0,0);
        System.out.println(maxW);
    }
}
