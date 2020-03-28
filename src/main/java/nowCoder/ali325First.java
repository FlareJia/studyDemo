package nowCoder;

import static java.lang.Math.abs;

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
// 回溯法解法
public class ali325First {
    public static int[][] list = {{5,10,5,4,4},{1,7,8,4,0},{3,4,9,0,3}};
    public static int minValue = Integer.MAX_VALUE;
    public static int count =0;

    public static void f(int[][] list, int rNum, int cNum, int curR, int curC, int curValue){
        if(curC == cNum-1){
            System.out.println("!!     "+curValue);
            count++;
            if(curValue < minValue){
                minValue = curValue;
            }
            return;
        }
        f(list,rNum,cNum,0,curC+1,curValue+abs(list[0][curC+1]-list[curR][curC]));
        f(list,rNum,cNum,1,curC+1,curValue+abs(list[1][curC+1]-list[curR][curC]));
        f(list,rNum,cNum,2,curC+1,curValue+abs(list[2][curC+1]-list[curR][curC]));
    }

    public static void main(String[] args) {
        f(list,3,5,0,0,0);
        f(list,3,5,1,0,0);
        f(list,3,5,2,0,0);
        System.out.println(minValue);
        System.out.println("count = "+count);
    }
}
