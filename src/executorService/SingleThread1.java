package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThread1 {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    for (int i = 0; i < 50; i++) {
      executorService.execute(new Task());
    }
  }

  static class Task implements Runnable {
    @Override
    public void run() {
      System.out.println("synchronous task running");
    }
  }
}
