package lesson61;

import java.util.Scanner;

public class Ex1 {

  // Вводят кол-во чисел, а затем и сами числа
  // Найти и вывести сумму всех чисел

  public static void main(String[] args) {    // time 7 * O(1) + 2 * O(n) = O(n)      space = O(n)
    Scanner scanner = new Scanner(System.in); // O(1)                                 O(1)
    int size = scanner.nextInt();             // O(1)                                 O(1)
    scanner.nextLine();                       // O(1)                                 O(1)
    int[] array = new int[size];              // O(1)                                 O(n)
    for (int i = 0; i < size; i++) {          // n раз = O(n)                         +O(1)
      array[i] = scanner.nextInt();           // - O(1)
    }
    int sum = 0;                              // O(1)                                 O(1)
    for (int i = 0; i < array.length; i++) {  // n раз = O(n)                         +O(1)
      sum += array[i];                        // - O(1)
    }
    System.out.println(sum);                  // O(1)
  }

  public void secondOption() {                // time = O(n)                          space = O(1)
    Scanner scanner = new Scanner(System.in); // O(1)                                 O(1)
    int size = scanner.nextInt();             // O(1)                                 O(1)
    int sum = 0;                              // O(1)                                 O(1)
    for (int i = 0; i < size; i++) {          // n раз = O(n)                         +O(1)
      int x = scanner.nextInt();              // - O(1)                               +O(1)
      sum += x;                               // - O(1)
    }
    System.out.println(sum);                  // O(1)
  }
}