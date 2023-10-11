import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static class ConcurrentTask implements Runnable {

        private final int number;
        public ConcurrentTask(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            System.out.println(this.number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for (int i = 1; i <= 10; i++) {
            executor.execute(new ConcurrentTask(i));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Tareas Terminadas");
    }
}