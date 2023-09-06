package lesson69_70;

public class MainLock extends Thread {

  static int counter = 0;
  // служебное слово synchronized зарезает запускать метод или блок кода

  // если синкронайзд относится к блоку кода, а не к методу, то в () требуется
  // указание объекта, к которому привязана блокировка
  static Object lock = new Object();

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new MainLock();
    thread.start();
    for (int i = 0; i < 50; i++) {
      synchronized (MainLock.class) {
        ++counter;
      }
    }
  }

  // Запустится, когда МейнЛок - основная программа
  @Override
  public void run() {
    for (int i = 0; i < 10000; ++i) {
      synchronized (MainLock.class) {
        ++counter; // гонка данных
      }
    }
  }
}

