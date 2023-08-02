package lesson50;

public class Main {

  public static void main(String[] args) {
    System.out.println("При вызове было указано " + args.length + " аргументов");
    boolean secret = false;
    for (String arg : args) {
      System.out.println("Аргумент: " + arg);
      if (arg.equalsIgnoreCase("Секрет")) {
        secret = true;
      }
    }
    if (secret) {
      System.out.println("Вы нашли секретный аргумент");
    }
  }
}
