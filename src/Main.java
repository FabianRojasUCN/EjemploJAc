import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 10; i++) {
            int number = i;
            executor.execute(() -> {
                System.out.println(number);
            });
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("Tareas Terminadas");
    }
}