package thread;

public class ThreadExample4 {
  public static void main(String[] args) {
    Runnable runnable = new Runnable() {
      @Override
      public void run() {
        System.out.println("MyThread running");
        System.out.println("MyThread finished");
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
  }
}
