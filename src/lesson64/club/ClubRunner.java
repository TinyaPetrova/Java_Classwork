package lesson64.club;

import java.util.Scanner;

public class ClubRunner {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Club club = new Club("Название");

    club.greet; // начало работы, "добро пожаловать"

    boolean choice = hasNextVisitors(scanner); // выбор команды (есть посетители или нет)
    while (!choice.equals(EXIT)) {
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
   * Чтение команды с клавиатуры (выбор команды)
   *
   * @param scanner
   * @return введённая пользоваелем команда
   */
  private static boolean hasNextVisitors(Scanner scanner) {
    System.out.println("Есть ли в очереди посетители? [Да/Нет]");
    String input = scanner.nextLine().toLowerCase();
    return (input.startsWith("д") || input.startsWith("y"));
  }
}
