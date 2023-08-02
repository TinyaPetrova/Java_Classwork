package lesson42;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Введите количество имён: ");
    int amount = scanner.nextInt();
    scanner.nextLine();
    List<String> names = new ArrayList<>();
    System.out.println("Введите " + amount + " имён, каждое с новой строки: ");
    for (int i = 0; i < amount; ++i) {
      names.add(scanner.nextLine());
    }
    printNumberedList(names);
  }

  private static void printNumberedList(List<String> words) {
    for (int i = 0; i < words.size(); ++i) {
      int k = i + 1;
      System.out.println(k + ". " + words.get(i));
    }
  }
}



