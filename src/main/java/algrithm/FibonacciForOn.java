package algrithm;

/**
 * 时间复杂度为O(n)的斐波那契数列求解
 */
public class FibonacciForOn {
    public static void main(String[] args) {
        for (int i=0; i< 10; i++){
            System.out.println(fibonacci(i));
        }
    }

    public static int fibonacci(int n){
        int f0 = 0;
        int f1 = 1;
        int f2 = 1;
        if(n<3){
            return n == 2 ? 1 : n;
        }

        for(int i=2; i<n; i++){
            f2 += f1;
            int temp = f1;
            f1 += f0;
            f0 = temp;
        }
        return f2;
    }
}
