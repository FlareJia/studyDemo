package oddEvenNumber;

public class PrintOddEvenSyn {
    private static int number = 1;
    private static final Object lock = new Object();
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(number<100){
                    synchronized (lock){
                        if ((number&1) == 1){
                            System.out.println(Thread.currentThread().getName() + " : " + number++);
                        }
                    }
                }
            }
        },"奇数线程").start();

        /**
         * 打99的时候，偶数线程已经过了判断number<100这一个代码段，阻塞在synchronized上。
         * 当99输出之后，奇数线程释放lock，偶数线程获取lock，进入输出100。
         */
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(number<100){
                    synchronized (lock){
                        if ((number&1) == 0){
                            System.out.println(Thread.currentThread().getName() + " : " + number++);
                        }
                    }
                }
            }
        },"偶数线程").start();
    }
}
