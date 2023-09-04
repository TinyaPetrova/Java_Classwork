package lesson69;

public class Main {

  // Multithreading: многопоточность
  public static void main(String[] args) {
    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        for (int i = 0; i < 50; i++) {
          System.out.println(i + ". I'm a new thread");
          System.out.println(i + ". I'm a new thread");
          System.out.println(i + ". I'm a new thread");
        }
      }
    });
    thread.start();
    for (int i = 0; i < 50; i++) {
      System.out.println(i + ". I'm the main thread");
      System.out.println(i + ". I'm the main thread");
      System.out.println(i + ". I'm the main thread");
    }
  }
}
