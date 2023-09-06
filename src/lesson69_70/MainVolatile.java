package lesson69_70;

import java.util.concurrent.atomic.AtomicInteger;

public class MainVolatile extends Thread {

  // volatile - пометка, обещание, что переменная будет потокобезопасной
  // Atomic - буквально "неделимый" - разновидность переменных, все операции с которыми
  // будут потокобезопасными
  volatile static AtomicInteger counter = new AtomicInteger(0);

  // запустится, когда MainVolatile - отдельный поток
  @Override
  public void run() {
    for (int i = 0; i < 10000; ++i) {
      counter.incrementAndGet(); // гонка данных
    }
  }

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Main3();
    thread.start();
    for (int i = 0; i < 50; i++) {
      System.out.println(counter.incrementAndGet() + ". I'm the main thread");
    }
  }
}
