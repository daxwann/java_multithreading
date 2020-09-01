package thread;

public class ThreadExample10 {
  public static void main(String[] args) {
    Runnable runnable = () -> {
      for (int i=0; i<5; i++) {
        sleep(1000);
        System.out.println(Thread.currentThread().getName() + " Running");
      }
      System.out.println(Thread.currentThread().getName() + " Stopped");
    };

    Thread thread = new Thread(runnable, "Thread 1");
    thread.setDaemon(true);
    thread.start();

    try {
      thread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Main thread stopped");
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
