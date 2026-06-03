import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class ComputeTask implements Callable<Integer> {
    private int number;

    public ComputeTask(int number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        return number * number;
    }
}

public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        List<Future<Integer>> results = new ArrayList<>();

        try {
            for (int i = 1; i <= 5; i++) {
                Callable<Integer> task = new ComputeTask(i);
                Future<Integer> future = executor.submit(task);
                results.add(future);
            }

            for (Future<Integer> future : results) {
                System.out.println("Task Result: " + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}