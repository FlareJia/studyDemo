package algrithm;

public class ZeroOneBagRecallNote {

    public static int maxW = Integer.MIN_VALUE;
    private static int[] weight = {2,2,4,6,3};
    private static int n = 5;
    private static int w = 9;
    // 为什么是10？？？ 因为10才能装下0-9这10个数
    private static boolean[][] men = new boolean[5][10];

    public static void recall(int i, int curW){
        if(curW == w || i==n){
            if(curW > maxW){
                maxW = curW;
            }
            return;
        }
        if(men[i][curW]){
            return;
        }
        men[i][curW] = true;

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
