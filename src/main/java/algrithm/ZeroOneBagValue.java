package algrithm;

public class ZeroOneBagValue {
    private static int maxVal = Integer.MIN_VALUE;
    private static int[] items = {2,2,4,6,3};
    private static int[] values = {3,4,8,9,6};
    private static int n = 5;
    private static int w = 9;

    public static void f(int i, int curW, int curValue){
        if(curW == w || i==n){
            if(curValue > maxVal){
                maxVal = curValue;
            }
            return;
        }
        f(i+1, curW, curValue);
        if(curW+items[i] <= w){
            f(i+1, curW+items[i], curValue+values[i]);
        }
    }

    public static void main(String[] args) {
        f(0,0,0);
        System.out.println(maxVal);
    }
}
