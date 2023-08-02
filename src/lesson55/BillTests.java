package lesson55;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Map;
import org.junit.jupiter.api.Test;

public class BillTests {

  @Test
  public void constructor() {
    // arrange & act - установить начальные значения и совершить действие
    Bill bill = new Bill();

    // assert - предположить, что результат правильный
    // проверить, что строк нет
    assertEquals(0, bill.getRows().size());
  }

  @Test
  public void addNewRow() {
    // 1. arrange - установить начальные значения
    Bill bill = new Bill();
    String title = "title";
    double price = 2.5;

    // 2. act - совершить действие
    bill.addRow(title, price);
    Map<String, Double> rows = bill.getRows();

    // 3. assert - предположить, что результат правильный
    // проверить, что строка только одна
    assertEquals(1, rows.size());
    // проверить, что названию title соответствует price
    double result = rows.get(title);
    assertEquals(price, rows.get(title));
  }
}
