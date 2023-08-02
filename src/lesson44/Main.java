//package lesson44;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Main {
//
//  private static final int ADD = 1;
//  private static final int CLOSE = 2;
//  private static final int EXIT = 0;
//  private static final int INCORRECT = -1;
//
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    System.out.println("=== Кассовый аппарат v. 0.0.1 ===");
//    Register register = new Register();
//    int command;
//    do {
//      command = readCommand(scanner);
//      switch (command) {
//        case ADD:
//          register.addInteractive(scanner);
//          break;
//        case CLOSE:
//          register.closeBill();
//          break;
//        case EXIT:
//          break;
//        default:
//          System.out.println("Некорректная команда: " + command);
//          break;
//      }
//    } while (command != EXIT);
//    System.out.println("До свидания!");
//  }
//
//  private static int readCommand(Scanner scanner) {
//    int command = INCORRECT;
//    while (!isCommand(command)) {
//      printMenu();
//      System.out.print("Выберите команду: ");
//      try {
//        command = scanner.nextInt();
//        if (isCommand(command)) {
//          System.out.println("Вы ввели номер команды: " + command);
//        }
//      } catch (InputMismatchException e) {
//        System.out.println("Некорректный ввод, введите номер команды");
//      } finally {
//        scanner.nextLine();
//      }
//    }
//    return command;
//  }
//
//  private static boolean isCommand(int command) {
//    switch (command) {
//      case ADD:
//      case CLOSE:
//      case EXIT:
//        return true;
//      default:
//        return false;
//    }
//  }
//
//  private static void printMenu() {
//    System.out.println("Команды: ");
//    System.out.println(ADD + ". Добавить позицию");
//    System.out.println(CLOSE + ". Закрыть чек");
//    System.out.println(EXIT + ". Выход");
//  }
//}
