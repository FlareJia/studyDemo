import javafx.concurrent.Task;

import java.util.concurrent.*;

public class iC implements Callable {
    @Override
    public Object call() throws Exception {
        return 1;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        iC iC = new iC();
        Future<Integer> future = exec.submit(iC);
        System.out.println(future.get());
        exec.shutdown();

    }
}
