package lesson46.task1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Task1 {

  /*
 Вводят список студентов в формате:
 Кол-во студентов
 Для каждого студента:
 - Имя
 - Группа
 В результате нужно вывести этот список в другом формате:
 Группа
 - студенты (по одному в строке)

 Для каждой группы - свой заголовок и свой список

 Пример входных данных:
 3
 Кирилл
 1
 Мефодий
 2
 Василий
 1

 Пример вывода:
 1
 Кирилл
 Василий
 2
 Мефодий
   */
  public static void main(String[] args) {
    // Map:
    // ключ1 -> значение
    // ключ2 -> значение
    //
    // ключ = № группы
    // значение = список имён
    Map<String, List<String>> result = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
//    Вариант с трай-кэтч неоч:
//    int amount = scanner.nextInt();
//    do {
//      try {
//        System.out.println("Введите кол-во студентов: ");
//        amount = scanner.nextInt();
//        if (amount > 0) {
//        break;
//      } catch (InputMismatchException e) {
//        System.out.println("Ошибка: некорректный ввод");
//      } finally {
//        scanner.nextLine();
//      }
//    } while (true);
    System.out.print("Введите кол-во студентов: ");
    while (!scanner.hasNextInt()) {
      String error = scanner.nextLine();
      System.out.print("Некорректный ввод: '" + error + "'" + ", введите целое число");
      System.out.print("Введите кол-во студентов: ");
    }
    int amount = scanner.nextInt();
    scanner.nextLine();
    if (amount < 1) { // условие-стражник (гардиан)
      System.out.println("У вас нет студентов");
      return;
    }
    System.out.println("Введите данные " + amount + " студентов");
    for (int i = 0; i < amount; ++i) {
      System.out.print("Введите имя: ");
      String name = scanner.nextLine();
      while (name.isEmpty()) {
        System.out.print("Имя не может быть пустым, введите имя: ");
        name = scanner.nextLine();
      }
      System.out.print("Введите группу: ");
      String group = scanner.nextLine();

      // не самый удачный способ:
      // если в мапе уже есть такой ключ
//      if (result.containsKey(group)) {
//        List<String> students = result.get(group);
//        students.add(name);
//        result.put(group, students);
//      } else {
//        List<String> students = new ArrayList<>();
//        students.add(name);
//        result.put(group, students);
//      }
      if (!result.containsKey(group)) {// если группу встретили первы раз
        // нужно создать для не список (поа пустой)
        result.put(group, new ArrayList<>());
      }
      result.get(group).add(name);
    }

    // for-each:
    // можно перебирать только ключи: Map.keySet() (множество ключей)
    // for (String group : result.keySet())
    // можно перебирать только значения (но зачем?): Map.values()
    // for (List<String> students : result.values())
    // можно перебирать пары ключ-значение (класс Map.Entry<K, V>): Map.entrySet() (множество пар)
    for (Map.Entry<String, List<String>> pair : result.entrySet()) {
      String group = pair.getKey();
      System.out.println(group);
      List<String> students = pair.getValue();
      for (String student : students) {
        System.out.println("- " + student);
      }
    }
  }
}
