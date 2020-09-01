package thread;

public class ThreadExample9 {

  public static void main(String[] args) {
    Runnable runnable = () -> {
      System.out.println(Thread.currentThread().getName() + " running");
      sleep(5000);
      System.out.println(Thread.currentThread().getName() + " Stopped");
    };

    Thread thread = new Thread(runnable, "Thread 1");
    thread.setDaemon(true);
    thread.start();
    sleep(3000);
    System.out.println("Main thread end");
  }

  public static void sleep(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
