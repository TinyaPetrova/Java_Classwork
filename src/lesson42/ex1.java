package lesson42;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex1 {

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите количество чисел: ");
    int amount = scanner.nextInt();
    System.out.println("Введите " + amount + " чисел/числа:");
    for (int i = 0; i < amount; ++i) {
//      int x = scanner.nextInt();
//      numbers.add(x);
      numbers.add(scanner.nextInt());
    }
//    System.out.println("[DEBUG] Получившийся список: " + numbers);
    for (int i = 0; i < numbers.size(); ++i) {
      if (i % 2 == 0) {
        System.out.print(numbers.get(i) + " ");
      }
    }
  }
}

