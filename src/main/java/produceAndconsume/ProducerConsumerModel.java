package produceAndconsume;


public class ProducerConsumerModel {
    public static void main(String[] args) {
        int maxSize = 100;
        DataStorage dataStorage = new DataStorage(maxSize);
        new Thread(new Producer(maxSize,dataStorage)).start();
        Consumer consumer = new Consumer(maxSize,dataStorage);
        Thread thread = new Thread(consumer);
        thread.start();
    }

    private static class Producer implements Runnable{

        private int maxSize;
        private DataStorage dataStorage;

        public Producer(int maxSize, DataStorage dataStorage) {
            this.maxSize = maxSize;
            this.dataStorage = dataStorage;
        }

        @Override
        public void run() {
            for (int i=0; i<maxSize; i++){
                dataStorage.put();
            }
        }
    }

    private static class Consumer implements Runnable{
        private int maxSize;
        private DataStorage dataStorage;

        public Consumer(int maxSize, DataStorage dataStorage) {
            this.maxSize = maxSize;
            this.dataStorage = dataStorage;
        }

        @Override
        public void run() {
            for (int i=0; i<maxSize; i++){
                dataStorage.take();
            }
        }
    }
}

