package produceAndconsume;

import java.util.LinkedList;
import java.util.Random;

public class DataStorage {
    private int maxSize;
    private LinkedList<Integer> storage;
    Random rand;
    public DataStorage(int maxSize) {
        this.maxSize = maxSize;
        this.storage = new LinkedList<>();
        rand = new Random();
    }

    public synchronized void put(){
        while (storage.size() == maxSize){
            try{
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(rand.nextInt(maxSize));
        System.out.println("仓库中有了" + storage.size() + "个产品");
        notify();
    }

    public synchronized void take(){
        while (storage.size() == 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("拿到了" + storage.poll() +",现在仓库还剩下" + storage.size() + "个产品");
        notify();
    }
}
