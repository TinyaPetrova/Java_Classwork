package lesson69_70;

public class Main3 extends Thread {

  // Multithreading: многопоточность
//  public static void main(String[] args) {
//    int counter = 0;
//    Thread thread = new Thread(() -> {
//        for (int i = 0; i < 50; i++) {
//          System.out.println(++counter + ". I'm a new thread");
//        }
//    });
//    thread.start();
//    for (int i = 0; i < 50; i++) {
//      System.out.println(++counter + ". I'm the main thread");
//    }
//  }
  static int counter = 0;

  @Override
  public void run() {
    for (int i = 0; i < 50; i++) {
      System.out.println(++counter + ". I'm a new thread");
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Main3();
    thread.start();
    for (int i = 0; i < 50; i++) {
      System.out.println(++counter + ". I'm the main thread");
    }
  }
}

