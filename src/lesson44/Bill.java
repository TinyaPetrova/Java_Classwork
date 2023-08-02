//package lesson44;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Bill {
//
//  //List<Row> rows = new ArrayList<>();
//
//  public void addInteractive(Scanner scanner) {
//    System.out.print("Введите название позиции: ");
//    String title = scanner.nextLine();
//
//    System.out.print("Введите стоимость: ");
//    while (!scanner.hasNextDouble()) {
//      System.out.println("Некорректный ввод, введите число: " + scanner.nextLine());
//    }
//    double price = scanner.nextDouble();
//    scanner.nextLine();
//
//    rows.add(new Row(title, price));
//  }
//
//  @Override
//  public String toString() {
//    StringBuilder result = new StringBuilder("Чек:\n");
//    for(Row row : rows) {
//      result.append(row).append("\n");
//    }
//    return result.toString();
//  }
//}
