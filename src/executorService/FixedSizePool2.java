package executorService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedSizePool2 {
  public static void main(String[] args) {
    int coreCount = Runtime.getRuntime().availableProcessors();
    System.out.println("Core count: " + coreCount);

    // for CPU intensive operations
    ExecutorService service = Executors.newFixedThreadPool(coreCount);

    for (int i = 0; i < 50; i++) {
      service.execute(new CpuIntensiveTask());
    }
  }

  static class CpuIntensiveTask implements Runnable {
    @Override
    public void run() {
      System.out.println("THIS IS INTENSE!!!");
    }
  }
}
