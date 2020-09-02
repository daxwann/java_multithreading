package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadLifeCycle {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(10);
    for (int i = 0; i < 100; i++) {
      service.execute(new Task());
    }

    // initiate shutdown
    System.out.println("shutdown");
    service.shutdown();

    boolean isShutdown = service.isShutdown();
    System.out.println("is shut down? " + isShutdown);

    boolean isTerminated = service.isTerminated();
    System.out.println("is terminated? " + isTerminated);

    service.awaitTermination(10, TimeUnit.SECONDS);

//    List<Runnable> runnableList = service.shutdownNow();
  }

  static class Task implements Runnable {
    @Override
    public void run() {
      System.out.println("running");
    }
  }
}
