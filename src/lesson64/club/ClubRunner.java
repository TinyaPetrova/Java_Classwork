package lesson64.club;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ClubRunner {

  private static final Set<String> POSITIVE_ANSWERS = new HashSet<>();

  static {
    POSITIVE_ANSWERS.add("yes");
    POSITIVE_ANSWERS.add("y");
    POSITIVE_ANSWERS.add("да");
    POSITIVE_ANSWERS.add("д");
  }

  private static final Set<String> NEGATIVE_ANSWERS = new HashSet<>();

  static {
    NEGATIVE_ANSWERS.add("");
    NEGATIVE_ANSWERS.add("no");
    NEGATIVE_ANSWERS.add("n");
    NEGATIVE_ANSWERS.add("нет");
    NEGATIVE_ANSWERS.add("н");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Club club = new Club("Название", 3, 21);

    club.greet(); // начало работы, "добро пожаловать"

    while (hasNextVisitors(scanner)) {
      if (!club.hasFreeSpace()) { // если нет мест, то заканчиваем цикл
        club.sorry();
        break;
      }
      // новый посетитель пытается попасть в клуб, пока есть места
      club.tryToEnter(Visitor.interactiveRead(scanner));
    }

    // распечатать отсортированный список всех посетителей
    club.printVisitorsByAge();
    club.close();
  }

  /**
   * Чтение ответа да/нет
   *
   * @param scanner источник ввода ответа
   * @return <code>true</code>, если "да"
   */
  private static boolean hasNextVisitors(Scanner scanner) {
    System.out.println("Есть ли в очереди посетители? [Да/Нет]");
    String input = scanner.nextLine();
    while (!POSITIVE_ANSWERS.contains(input) && !NEGATIVE_ANSWERS.contains(input)) {
      System.out.println("Введите да или нет");
      input = scanner.nextLine();
    }
    return POSITIVE_ANSWERS.contains(input.toLowerCase());
  }
}
