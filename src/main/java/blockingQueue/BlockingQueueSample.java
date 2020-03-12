package blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueSample {


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        arrayBlockingQueue.put("1");
        arrayBlockingQueue.put("2");
        arrayBlockingQueue.put("3");
        arrayBlockingQueue.put("4");
        arrayBlockingQueue.put("5");
        System.out.println(arrayBlockingQueue.size());
        System.out.println(arrayBlockingQueue.take());
        arrayBlockingQueue.put("1");
        System.out.println(arrayBlockingQueue.size());

    }
}
