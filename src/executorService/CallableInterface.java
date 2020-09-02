package executorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableInterface {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(10);
    System.out.println("Submit callable");
    List<Future<Integer>> futureList = new ArrayList<>();
    for (int i = 0; i < 50; i++) {
      futureList.add(service.submit(new Task()));
    }

    //perform other operations
    Thread.sleep(6000);
    System.out.println("other operations running");

    futureList.stream().forEach(future -> {
      try {
        Integer result = future.get();
        System.out.println("future returns result: " + result);
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
    });
  }

  static class Task implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
      Thread.sleep(500);
      return new Random().nextInt();
    }
  }
}
