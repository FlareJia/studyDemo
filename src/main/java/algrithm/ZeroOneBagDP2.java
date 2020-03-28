package algrithm;

public class ZeroOneBagDP2 {
    private static int[] weight = {2,2,4,6,3};
    private static int n = 5;
    private static int w = 9;

    public static int knapsack2(int[] weight, int n, int w){
        boolean[] states = new boolean[w+1];
        states[0] = true;
        if(weight[0] <= w){
            states[weight[0]] = true;
        }

        for (int i=1; i<n; i++){
            // j<= w-weight[i] 用来减少遍历的次数
            // 这里的j必须从大到小来处理，否则会重复计算
            for(int j=w-weight[i]; j>0; j--){
                if (states[j]==true){
                    states[j+weight[i]] = true;
                }
            }
        }

        for(int i=w; i>=0; i--){
            if(states[i]==true){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(knapsack2(weight, n, w));
    }
}
