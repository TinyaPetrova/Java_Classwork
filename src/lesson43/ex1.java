package lesson43;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите количество имён: ");
    int amount = scanner.nextInt();
    scanner.nextLine();
    List<String> names = new ArrayList<>();
    System.out.println("Введите " + amount + " имён, каждое с новой строки: ");
    for (int i = 0; i < amount; ++i) {
      names.add(scanner.nextLine());
    }
    printNumberedList(names);

    System.out.print("Введите номер имени, которое хотите заменить: ");
    int ordToRemove = scanner.nextInt();
    scanner.nextLine();
    System.out.println("Старое имя: " + names.get(ordToRemove - 1));
    names.remove(ordToRemove - 1);
    System.out.println("Введите новое имя: ");
    String name = scanner.nextLine();
    names.add(ordToRemove - 1, name);
    System.out.println("Имена после замены: ");
    printNumberedList(names);
  }

  private static void printNumberedList(List<String> words) {
    for (int i = 0; i < words.size(); ++i) {
      int k = i + 1;
      System.out.println(k + ". " + words.get(i));
    }
  }
}




