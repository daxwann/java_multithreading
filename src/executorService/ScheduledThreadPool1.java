package executorService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool1 {
  public static void main(String[] args) {
    // for scheduling of tasks
    ScheduledExecutorService service = Executors.newScheduledThreadPool(10);

    // task to run after 5 second delay
    service.schedule(new Task(), 5, TimeUnit.SECONDS);

    // task to run repeatedly every 5 seconds
    service.scheduleAtFixedRate(new Task(), 10, 5, TimeUnit.SECONDS);

    // task to run repeatedly 10 seconds after prev tasks complete
    service.scheduleWithFixedDelay(new Task(), 5, 10, TimeUnit.SECONDS);
  }

  static class Task implements Runnable {
    @Override
    public void run() {
      System.out.println("Scheduled task running");
    }
  }
}
