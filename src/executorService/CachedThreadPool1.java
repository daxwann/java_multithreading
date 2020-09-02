package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool1 {
  public static void main(String[] args) {
    // for large number of short lived tasks
    ExecutorService service = Executors.newCachedThreadPool();

    for (int i = 0; i < 50; i++) {
      service.execute(new Task());
    }
  }

  static class Task implements Runnable {
    @Override
    public void run() {
      System.out.println("Short lived task running");
    }
  }
}
