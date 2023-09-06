package lesson69_70;

public class MainSynchronized extends Thread {

  static int counter = 0;

  // служебное слово "synchronized" запрещает запускать метод или блок кода
  // в разных потоках одновременно - если овый поток подойдёт к этому месту,
  // он будет дожидаться предыдущего вызова

  synchronized public static void increaseCounter() {
    ++counter;
  }

  // ++counter
  // MAIN - взять каунтер
  // THREAD - взять каунтер
  // MAIN - увеличить на 1
  // THREAD - увеличить на 1
  // MAIN - записать получившееся в каунтер
  // THREAD - записать получившееся в каунтер

  @Override
  public void run() {
    for (int i = 0; i < 10000; ++i) {
      increaseCounter(); // гонка данных
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
