package lesson50;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.IIOException;

public class Task03Files {
  // Прочитать из файла res/input.txt имена и накопленные баллы
  // Вывести студента с наибольшим кол-вом баллов в файл res/output.txt
  public static void main(String[] args) throws IOException {
    // Класс Файл используется для хранения информации о файле
    // Информация мб некорректной
    File input = new File("Excercises/res/input.txt");
    Scanner scanner;
    try {
      scanner = new Scanner(new File("Excercises/res/input.txt"));
    } catch (FileNotFoundException e) {
      System.err.println("Файл не найден: " + e.getMessage());
      return;
    }
    String resultName = scanner.next();
    int resultScore = scanner.nextInt();
    while (scanner.hasNext()) {
      String name = scanner.next();
      int score = scanner.nextInt();
      if (score > resultScore) { // если прочитанные баллы > чем всё, что было раньше
        resultScore = score; // это новый самый большой балл
        resultName = name; // это новый лучший ученик
      }
    }
    scanner.close();

    File output = new File("Excercises/res/output.txt");
    // Файлрайтер - класс для записи данных в (новый) файл
    FileWriter writer;
    try {
      writer = new FileWriter(output);
    } catch (IIOException e) {
      System.err.println("Не получилось открыть файл для записи: " + e.getMessage());
      return;
    }
    writer.write(resultName + "\n");
    writer.close();
  }
}
