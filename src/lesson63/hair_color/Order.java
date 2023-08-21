package lesson63.hair_color;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Order {

  private static final double PRICE_PER_CM = 1.5; // евро за см длины

  private static final double MULTIPLIER_PER_СOLOR = 0.2; // 20% за каждый цвет


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
    this.colors = checkColors(colors);
    this.length = checkLength(length);
    calculatePrice();
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

  /**
   * Проверка цветов на корректность
   *
   * @param colors цвета для проверки
   * @return корректные цвета
   */
  private int checkColors(int colors) {
    if (length < 0) {
      throw new IllegalArgumentException("Количество цветов не может быть отрицательным");
    }
    return colors;
  }

  public void setColors(int colors) {
    if (colors < 0) {
      throw new IllegalArgumentException("Количество цветов не может быть отрицательным");
    }
    this.colors = colors;
    calculatePrice();
  }

  /**
   * Проверка длины на корректность
   *
   * @param length исходная длина
   * @return корректная длина
   */
  private double checkLength(double length) {
    if (length < 0) {
      throw new IllegalArgumentException("Длина не может быть отрицательной");
    }
    return length;
  }

  public void setLength(double length) {
    this.length = length;
    calculatePrice();
  }


  public void setPrice(double price) {
    this.price = price;
  }

  /**
   * Обновление поля <code>price</code> с использованием значений полей <code>length</code> и
   * <code>colors</code>
   */
  private void calculatePrice() {
    price = PRICE_PER_CM * length + MULTIPLIER_PER_СOLOR * colors;
  }

  /**
   * Интерактивное чтение данных о заказе
   *
   * @param scanner источник данных
   * @return прочитанный заказ
   */
  public static Order interactiveRead(Scanner scanner) {
    System.out.print("Введите имя заказчика: ");
    String name = scanner.nextLine();
    System.out.print("Введите время начала: ");
    LocalTime startTime = LocalTime.now();
    boolean startTimeRead = false;
    while (!startTimeRead) {
      String startTimeInput = scanner.nextLine();
      try {
        startTime = LocalTime.parse(startTimeInput);
        startTimeRead = true;
      } catch (DateTimeParseException e) {
        System.out.print("Некорректный ввод: " + startTimeInput);
        System.out.print("Введите время в формате HH:MM: ");
      }
    }
    System.out.print("Укажите планируемое количество цветов: ");
    while (!scanner.hasNextInt()) {
      System.out.print("Некорректный ввод: " + scanner.nextLine());
      System.out.print("Введите целое число: ");
    }
    int colors = scanner.nextInt();
    scanner.nextLine(); // пропускаем весь ввод после числа до нажатия клавиши Enter
    System.out.print("Укажите длину волос в сантиметрах: ");
    while (!scanner.hasNextDouble()) {
      System.out.println("Некорректный ввод: " + scanner.nextLine());
      System.out.print("Введите число: ");
    }
    double length = scanner.nextDouble();
    scanner.nextLine(); // дочитываем ОБЯЗАТЕЛЬНО последнюю строку до конца
    return new Order(name, startTime, colors, length);
  }

  @Override
  public String toString() {
    return "Order{" +
        "name='" + name + '\'' +
        ", startTime=" + startTime +
        ", colors=" + colors +
        ", length=" + length +
        ", price=" + price +
        '}';
  }
}
