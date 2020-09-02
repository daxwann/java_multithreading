package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedSizePool1 {
  public static void main(String[] args) {
    // for IO intensive operations
    ExecutorService service = Executors.newFixedThreadPool(100);

    // submit tasks
    for (int i = 0; i < 50; i++) {
      service.execute(new Task());
    }

    System.out.println("Thread name: " + Thread.currentThread().getName());
  }

  static class Task implements Runnable {
    @Override
    public void run() {
      System.out.println("Thread name: " + Thread.currentThread().getName());
    }
  }
}
