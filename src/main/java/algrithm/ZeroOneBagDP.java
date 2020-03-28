package algrithm;

public class ZeroOneBagDP {
    private static int[] weight = {2,2,4,6,3};
    private static int n = 5;
    private static int w = 9;

    public static int knapsack(int[] weight, int n, int w){
        boolean[][] states = new boolean[n][w+1];
        states[0][0] = true;
        if(weight[0] <= w){
            states[0][weight[0]] = true;
        }

        for (int i=1; i<n; i++){
            for (int j= 0; j<= w; j++){
                if(states[i-1][j]==true){
                    states[i][j] = true;
                }
            }
            // j<= w-weight[i] 用来减少遍历的次数
            for(int j=0; j<= w-weight[i]; j++){
                if (states[i-1][j]==true){
                    states[i][j+weight[i]] = true;
                }
            }
        }

        for(int i=w; i>=0; i--){
            if(states[n-1][i]==true){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(knapsack(weight, n, w));
    }
}
