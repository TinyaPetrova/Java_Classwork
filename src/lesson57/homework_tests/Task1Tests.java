package lesson57.homework_tests;

import static lesson57.homework_tests.Task1.readDictionary;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

public class Task1Tests {

  // TODO тест на пустой файл (будет ошибка)

  @Test
  public void readEmptyDictionary() {
    // arrange - задать начальные значения
    String input = "0\n";
    Scanner scanner = new Scanner(input); // делает ввод из указанной строки

    // act & assert
    assertThrowsExactly(NoSuchElementException.class, () -> readDictionary(scanner));

//      // act - совершить действие
//      Map<String, String> dictionary = readDictionary(scanner);
//
//      // assert - предположить, что результат правильный
//      assertTrue(dictionary.isEmpty());
  }

  @Test
  public void readNegativeAmount() {
    // arrange - задать начальные значения
    String word1 = "word1";
    String definition1 = "definition1";
    String separator = ": ";

    // это как бы наш файл:
    // 1
    // word1: definition1
    String input = "-1\n"
        + word1 + separator + definition1 + '\n';
    Scanner scanner = new Scanner(input);

    // act - совершить действие
    // for (int i = 0; i < n; ++i)
    // 'i < -1' неверно с самого начала - мы даже не попадём в цикл
    Map<String, String> dictionary = readDictionary(scanner);

    // assert - предположить, что результат правильный
    assertFalse(dictionary.isEmpty());
    // избыточные проверки
    assertEquals(0, dictionary.size());
    assertTrue(dictionary.containsKey(word1));
    assertEquals(definition1, dictionary.get(word1));
  }

  @Test
  public void readCommonDictionary() {
    // arrange - задать начальные значения
    String word1 = "word1";
    String definition1 = "definition1";
    String word2 = "word2";
    String definition2 = "definition2";
    String separator = ": ";

    // это как бы наш файл:
    // 2
    // word1: definition1
    // word2: definition2
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(2).append('\n')
        .append(word1).append(separator).append(definition1).append('\n')
        .append(word2).append(separator).append(definition2).append('\n');
    Scanner scanner = new Scanner(stringBuilder.toString());

    // act - совершить действие
    Map<String, String> dictionary = readDictionary(scanner);

    // assert - предположить, что результат правильный
    assertFalse(dictionary.isEmpty());
    assertEquals(2, dictionary.size());
    assertTrue(dictionary.containsKey(word1));
    assertEquals(definition1, dictionary.get(word1));
    assertTrue(dictionary.containsKey(word2));
    assertEquals(definition2, dictionary.get(word2));
  }

  @Test
  public void readNotAllFile() {
    // arrange - задать начальные значения
    String word1 = "word1";
    String definition1 = "definition1";
    String word2 = "word2";
    String definition2 = "definition2";
    String separator = ": ";

    // это как бы наш файл:
    // 1
    // word1: definition1
    // word2: definition2

    String stringBuilder = "1\n"
        + word1 + separator + definition1 + '\n'
        + word2 + separator + definition2 + '\n';
    Scanner scanner = new Scanner(stringBuilder);
    // act - совершить действие
    Map<String, String> dictionary = readDictionary(scanner);

    // assert - предположить, что результат правильный
    assertFalse(dictionary.isEmpty()); // избыточная проверка
    assertEquals(1, dictionary.size());
    assertTrue(dictionary.containsKey(word1)); // избыточная проверка
    assertEquals(definition1, dictionary.get(word1));
    assertFalse(dictionary.containsKey(word2));
    assertNull(dictionary.get(word2)); // избыточная проверка
  }

  @Test
  public void readSeveralDefinitions() {
    // arrange - задать начальные значения
    String word1 = "word1";
    String definition1 = "definition1";
    String definition2 = "definition2";
    String separator = ": ";

    // это как бы наш файл:
    // 2
    // word1: definition1
    // word2: definition2

    String stringBuilder = "2\n"
        + word1 + separator + definition1 + '\n'
        + word1 + separator + definition2 + '\n';
    Scanner scanner = new Scanner(stringBuilder);
    // act - совершить действие
    Map<String, String> dictionary = readDictionary(scanner);

    // assert - предположить, что результат правильный
    assertFalse(dictionary.isEmpty()); // избыточная проверка
    assertEquals(1, dictionary.size());
    assertTrue(dictionary.containsKey(word1)); // избыточная проверкаЫ
    assertFalse(dictionary.containsValue(definition1)); // первое определение затёрто
    assertEquals(definition2, dictionary.get(word1)); // word1 соответствует второе определение
  }

  @Test
  public void readFileAfterEnd() {
    // arrange
    String input = "1\n"; // должна быть запись, но записи нет
    Scanner scanner = new Scanner(input); // делает ввод из указанной строки

    boolean caught = false;
    // act
    try {
      readDictionary(scanner);
    } catch (NoSuchElementException e) {
      // можно добавить проверку на сообщение
      caught = true;
    }

    // assert
    assertTrue(caught);

    // assertThrowsExactly(NoSuchElementException.class, () -> readDictionary(scanner));
  }

  // TODO одинаковые слова с разными определениями
}
