package casAndfaa;

import com.sun.xml.internal.ws.util.CompletedFuture;
import org.apache.commons.lang3.time.StopWatch;

import java.util.LinkedList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CASThread {
    private static AtomicInteger balance = new AtomicInteger(0);

    public static void main(String[] args) {
        // 执行多少次
        int count = 10000;

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        for (int i=0; i<count; i++){
            CompletableFuture.runAsync(() -> transfer1(1));
//            CompletableFuture.runAsync(() -> transfer2(1));
        }
        // 查看线程是否完全执行完毕
        while (balance.get() < count){
            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Used time "+ stopWatch.getTime() + " ms");
        System.out.println("balance is "+ balance);
    }

    //CAS
    public static void transfer1(int amount){
        while(true){
            int old = balance.get();
            int newBalance = old + amount;
            if (balance.compareAndSet(old,newBalance)){
                break;
            }
        }
    }

    //FAA
    public static void transfer2(int amount){
        balance.addAndGet(amount);
    }

}
