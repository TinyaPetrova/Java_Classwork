package lesson69_70;

public class Main2 extends Thread {

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      System.out.println(i + ". I'm a new thread");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Main2();
    Thread myThread = new MyThread(50);
    thread.start();
    for (int i = 0; i < 50; i++) {
      System.out.println(i + ". I'm the main thread");
      System.out.println(i + ". I'm the main thread");
      System.out.println(i + ". I'm the main thread");
    }
    thread.join(); // подождать завершение потока
    myThread.start();
  }
}
