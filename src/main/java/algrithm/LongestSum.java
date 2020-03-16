package algrithm;

public class LongestSum {
    public static void main(String[] args) {
        int[] list = {1,-2,3,10,-4,7,2,-5};
        GetResult getResult = new GetResult();
        System.out.println(getResult.gets(list));
    }

    public static class GetResult{


        public int gets(int[] list){
            int dp[] = new int[list.length];

            for (int i=0; i<list.length; i++){
                if(i==0 || dp[i-1]<=0){
                    dp[i] = list[i];
                }
                else {
                    dp[i] = dp[i-1] + list[i];
                }
            }

            int max = dp[0];
            for (int i=0; i<dp.length; i++){
                if (max <dp[i]){
                    max = dp[i];
                }
            }
            return max;
        }
    }


}
