package nowCoder;

import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * 作者：海森堡CSQ
 * 链接：https://www.nowcoder.com/discuss/391530?type=1
 * 来源：牛客网
 *
 * 第一题，给定一个数组n，比如
 * 5 10 5 4 4
 * 1  7  8 4 0
 * 3  4  9 0 3
 * 从每一列选择一个数，求出后一列减去前一列的绝对值的和的最小值
 * 比如这里就是5 7 5 4 4，所以输出是5
 */
//动态规划
public class ali325First2 {
    public static int[][] list = {{5,10,5,4,4},{1,7,8,4,0},{3,4,9,0,3}};
    public static int minValue = Integer.MAX_VALUE;
    public static int count =0;
    public static int[][] dp = new int[3][5];
    public static void main(String[] args) {
        //初始化第一列
        for(int i=0; i<3; i++){
            dp[i][0] = 0;
        }

        for(int i=1; i<5; i++){ // 列数
            for(int j=0; j<3; j++){ // 行数
                int a = abs(list[j][i] - list[0][i-1]);
                int b = abs(list[j][i] - list[1][i-1]);
                int c = abs(list[j][i] - list[2][i-1]);
                dp[j][i] = min(min(dp[0][i-1],dp[1][i-1]),dp[2][i-1]) + min(min(a,b),c);
            }
        }

        for (int i=0; i<3; i++){
            for(int j=0; j<5; j++){
                System.out.print(dp[i][j]);
            }
            System.out.println("");
        }

        for(int i=0; i<3; i++){
//            System.out.println(dp[i][4]);
            if(dp[i][4] < minValue){
                minValue = dp[i][4];
            }
        }
        System.out.println("reslut is : "+minValue);
    }
}
