package oddEvenNumber;

public class PrintOddEvenWait{

    private static int number = 1;
    private static final Object lock = new Object();

    public static void main(String[] args) {

    printNumber printOdd = new printNumber();
    printNumber printEven = new printNumber();
    Thread thread1 = new Thread(printOdd);
    thread1.setName("线程1");
    Thread thread2 = new Thread(printEven);
    thread2.setName("线程2");
    thread1.start();
    thread2.start();
    }

    private static class printNumber implements Runnable{

        @Override
        public void run() {
            while(number<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName() + " : " + number++);
                    lock.notify();
                    if (number<=100){
                        try{
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }


}
