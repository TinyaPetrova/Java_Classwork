package lesson69_70;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainExecutorService {

  private static final ExecutorService executorService = Executors.newFixedThreadPool(4);

  public static void main(String[] args) {
    for (int i = 0; i < 10; i++) {
      String taskName = "Task " + (i + 1);
      executorService.submit(() -> System.out.println(taskName));
    }
    executorService.shutdown();
  }
}
