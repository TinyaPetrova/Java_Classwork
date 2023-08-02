package lesson43;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ex4 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите количество имён: ");
    int amount = scanner.nextInt();
    if (amount <= 0) {
      return;
    }
    scanner.nextLine();
    List<String> names = new ArrayList<>();
    System.out.println("Введите " + amount + " имён, каждое с новой строки: ");
    for (int i = 0; i < amount; ++i) {
      names.add(scanner.nextLine());
    }

    replaceName(scanner, names);

    System.out.println("Имена после замены: ");
    printNumberedList(names);
  }

  private static void printNumberedList(List<String> words) {
    for (int i = 0; i < words.size(); ++i) {
      int k = i + 1;
      System.out.println(k + ". " + words.get(i));
    }
  }

  private static void replaceName(Scanner scanner, List<String> names) {
    if (names.isEmpty()) {
      return;
    }
    printNumberedList(names);
    System.out.print("Введите номер имени, которое хотите заменить: ");
    try {
      int ordToReplace = scanner.nextInt();
      int iToReplace = ordToReplace - 1;
      System.out.println("Старое имя: " + names.get(iToReplace));
      System.out.println("Введите новое имя: ");
      String name = scanner.nextLine();
      names.set(iToReplace, name);
    } catch (IndexOutOfBoundsException e) {
      System.err.println("Некорректный индекс: " + e.getMessage());
    } catch (InputMismatchException e) {
      System.err.println("Некорректный ввод, введите целое число");
    }
  }
}







