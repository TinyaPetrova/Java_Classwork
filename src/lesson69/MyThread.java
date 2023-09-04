package lesson69;

public class MyThread extends Thread {

  private final int limit;

  public MyThread(int limit) {
    this.limit = limit;
  }

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      System.out.println(i + ". I'm a new thread");
    }
  }
}
