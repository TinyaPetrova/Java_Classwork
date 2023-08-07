package lesson57;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    // как тестировать компаратор:
    // компаратор сравнивает 2 объекта, именно результат сравнения и нужно проверять
    // - два одинаковых объекта
    // - два разных объекта (сначала все пункты сравнения проверяем по отдельости)
    //   например, 2 книги с разными названиями, но одинаковые во всм остальном
    // - сравнения с приоритетом (отличаются и авторы, и названия, но "в разные стороны")
    // - один и тот же объект сам с собой
    // - что-то и null (throws NullPointerException)

    // новая тема: работа с датами в Java
    // первый вариант: класс Date (устарел с выходом джавы 8 в 2014 году!!!!!!)
    // второй вариант: класс Calendar (заменил часть методов Date и используется в связке с ним)
    // третий вариант: пакет java.time (появился в джава 8)
    // сейчас пользуются джавой 11 и 17
    // джава 8 это например какие-нибудь банки, государственное и т. д. старше встречается оч оч редко

    // будем работать с java.time
    // - LocalDate - хранит только дату без учёта времени (5-е августа 2023 г)
    // - LocalTime - хранит только время без учёта даты (15:27:34)
    // - LocalDateTime - хранит и дату, и время
    // - ZonedDateTime - хранит и дату, и время, и тайм-зону
    // у всех этих классов есть статический метод .now(), возвращающий текущий момент времени,
    // и статические методы .of(), работающие как конструкторы

    System.out.println("Сейчас " + LocalTime.now());
    System.out.println("Сейчас " + LocalTime.now().withNano(0));
    System.out.println("12:34: " + LocalTime.of(12, 34));

    System.out.println("Сегодня: " + LocalDate.now());
    System.out.println("01.02.2003: " + LocalDate.of(2003, Month.FEBRUARY, 1));

    System.out.println("Сегодня и сейчас: " + LocalDateTime.now());

    Scanner scanner = new Scanner(System.in);
    // формат ввода и вывода:
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    // читаем ввод:
    System.out.println("Введите день рождения в формате ДД.ММ.ГГГГ: ");
    String dateStr = scanner.nextLine();
    LocalDate birthday = LocalDate.parse(dateStr, formatter);
    System.out.println("Введённая дата: " + birthday);
    System.out.println("Введённая дата в исходном формате: " + birthday.format(formatter));
  }
}
