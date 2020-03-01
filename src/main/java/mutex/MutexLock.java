package mutex;

import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexLock {

    private static int balance = 0;

    public static void main(String[] args) {
        int count = 10000000;
        Lock lock = new ReentrantLock();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i=0; i<count; i++){
            CompletableFuture.runAsync(() -> transfer(1, lock));
        }
        while (balance < count){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Used time "+ stopWatch.getTime());
        System.out.println("balance is "+ balance);
    }

    public static void transfer(int amount, Lock lock){
        lock.lock();
        try{
            balance += amount;
        } finally {
            lock.unlock();
        }
    }
}
