package deadLock;

public class MustDeadLock implements Runnable {

    public int flag = 1;
    static Object object1 = new Object();
    static Object object2 = new Object();

    public static void main(String[] args) {
        MustDeadLock mustDeadLock1 = new MustDeadLock();
        MustDeadLock mustDeadLock2 = new MustDeadLock();
        mustDeadLock1.flag = 1;
        mustDeadLock1.flag = 0;
        Thread thread1 = new Thread(mustDeadLock1);
        Thread thread2 = new Thread(mustDeadLock2);
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        System.out.println("flag = " + flag);
        if(flag==1){
            synchronized (object1){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2){
                    System.out.println("1");
                }
            }
        }
        if(flag==0){
            synchronized (object2){
                try{
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1){
                    System.out.println("0");
                }
            }
        }
    }
}
