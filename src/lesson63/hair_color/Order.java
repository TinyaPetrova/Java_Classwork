package lesson63.hair_color;

import java.time.LocalTime;
import java.util.Scanner;

public class Order {

  private String name; // имя заказчика

  private LocalTime startTime; // время начала
  // TODO продолжительность

  private int colors; // кол-во цветов
  // TODO список цветов

  private double length; // длина волос

  private double price; // сумма заказов

  public Order(String name, LocalTime startTime, int colors, double length) {
    this.name = name;
    this.startTime = startTime;
    this.colors = colors;
    this.length = length;
  }

  public String getName() {
    return name;
  }

  public LocalTime getStartTime() {
    return startTime;
  }

  public int getColors() {
    return colors;
  }

  public double getLength() {
    return length;
  }

  public double getPrice() {
    return price;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setStartTime(LocalTime startTime) {
    this.startTime = startTime;
  }

  public void setColors(int colors) {
    this.colors = colors;
  }

  public void setLength(double length) {
    this.length = length;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public static Order interactiveRead(Scanner scanner) {
    System.out.print("Введите имя заказчика: ");
    String name = scanner.nextLine();
    System.out.print("Введите время начала: ");
    LocalTime startTime = LocalTime.parse(scanner.nextLine());
    System.out.print("Укажите планируемое количество цветов: ");
    int colors = scanner.nextInt();
    scanner.nextLine(); // пропускаем весь ввод после числа до нажатия enter (для себя)
    System.out.print("Укажите длину волос в см: ");
    double length = scanner.nextDouble();
    scanner.nextLine(); // тут ОБЯЗАТЕЛЬНО дочитываем последнюю строку до конца
    return new Order(name, startTime, colors, length);
  }
}
