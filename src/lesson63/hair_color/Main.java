package lesson63.hair_color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
  // анонимные классы - одноразовые классы для локального использования (типа компараторы)

  // База заказов на окрашивание волос
  // каждый заказ должен содержать:
  // - имя заказчика
  // - время начала
  // TODO продолжительность
  // - кол-во цветов
  // TODO список цветов
  // - длина волос
  // - расчёт суммы

  // Вывод заказов с двумя видами сортировки:
  // - по времени начала
  // - по сумме заказа

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Введите количество заказов: ");
    int size = scanner.nextInt();
    scanner.nextLine();
    List<Order> orders = new ArrayList<>(size);
    for (int i = 0; i < size; i++) {
      Order order = Order.interactiveRead(scanner);
      orders.add(order);
    }

    System.out.println("Выберите способ сортировки: ");
    System.out.println("1. По времени начала");
    System.out.println("2. По возрастанию");
    int mode = scanner.nextInt();
    switch (mode) {
      case 1:
        printOrdersByStartTime((ArrayList<Order>) orders);
        break;
      case 2:
        printOrdersByPrice((ArrayList<Order>) orders);
        break;
      default:
        System.out.println("Нет такой опции");
        break;
    }
  }

  private static void printOrdersByStartTime(ArrayList<Order> orders) {
    orders.sort(new Comparator<Order>() {
      @Override
      public int compare(Order o1, Order o2) {
        return o1.getStartTime().compareTo(o2.getStartTime());
      }
    });
    printOrders(orders);
  }

  private static void printOrdersByPrice(ArrayList<Order> orders) {
    orders.sort(new Comparator<Order>() {
      @Override
      public int compare(Order o1, Order o2) {
        return Double.compare(o1.getPrice(), (o2.getPrice()));
      }
    });
    printOrders(orders);
  }

  private static void printOrders(ArrayList<Order> orders) {
    for (int i = 0; i < orders.size(); i++) {
      System.out.println((i + 1) + ". " + orders.get(i));
    }
  }

  @Override
  public String toString() {
    return "{}";
  }
}
