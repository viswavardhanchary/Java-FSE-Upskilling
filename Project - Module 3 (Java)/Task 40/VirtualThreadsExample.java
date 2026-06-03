import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsExample {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            final int index = i;
            Thread vThread = Thread.startVirtualThread(() -> {
                if (index % 20000 == 0) {
                    System.out.println("Virtual Thread " + index + " executing");
                }
            });
            threads.add(vThread);
        }

        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Total Execution Time: " + (endTime - startTime) + " ms");
    }
}