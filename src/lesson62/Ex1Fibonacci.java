package lesson62;

import java.util.Scanner;

public class Ex1Fibonacci {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    System.out.println(n + "-ое число Фибоначчи: " + fibonacci(n));
  }

  // Числа Фибоначчи: каждое след. число - сумма двух предыдущих
  // чаще всего начинаются как 1, 1... и тд: 2, 3, 5, 8, 13...
  private static int fibonacci(int n) {
    if (n <= 2) { // базис рекурсии
      return 1; // из рекурсии обязательно нужно выйти
    }
    // предыдущее: fibonacci(n - 1)
    int prev1 = fibonacci(n - 1); // шаг рекурсии - "возврат к предыдущему", уменьшение размера
    // предыдущее: fibonacci(n - 2)
    int prev2 = fibonacci(n - 2);
    return prev1 + prev2;
  }
  // n: (n - 1) + (n - 2)
  // n: (n - 2) + (n - 3) + (n - 2)
}
