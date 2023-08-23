package lesson64.club;

import java.util.ArrayList;
import java.util.List;

public class Club {

  private final String title;
  private final int capacity;
  private final int allowedAge;
  private final List<Visitor> visitors = new ArrayList<>();


  public Club(String title, int capacity, int allowedAge) {
    this.title = title;
    this.capacity = capacity;
    this.allowedAge = allowedAge;
  }

  /**
   * Вывод сообщения о начале работы клуба
   */
  public void greet() {
    System.out.println("Добро пожаловать в клуб \"" + title + "\"");
  }

  /**
   * Проверка наличия своб мест
   *
   * @return <code>true</code> при наличии своб мест
   */
  public boolean hasFreeSpace() {
    return visitors.size() < capacity;
  }

  /**
   * Извинение при отсутствии мест
   */
  public void sorry() {
    System.out.println("Извините, мест нет");
  }

  /**
   * Попытка попасть в клуб
   *
   * @param visitor потенциальный посетитель
   */
  public void tryToEnter(Visitor visitor) {
    if (visitor.getAge() < allowedAge) {
      System.out.println("Извините, вам нельзя в клуб");
      return;
    }
    visitors.add(visitor);
  }

  /**
   * Вывод списка посетителей, отсортированного по возрасту в порядке возрастания
   */
  public void printVisitorsByAge() {
    System.out.println("В клуб \"" + title + "\" сейчас " + visitors.size() + " посетителей: ");
    List<Visitor> visitorsList = new ArrayList<>(visitors);
    visitorsList.sort((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge()));
    for (Visitor v : visitors) {
      System.out.println(v);
    }
  }

  /**
   * Сообщение о закрытии клуба
   */
  public void close() {
    System.out.println("Клуб \"" + title + "\" закрывает свои двери до следующего раза");
  }
}
