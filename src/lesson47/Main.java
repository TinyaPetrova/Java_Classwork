package lesson47;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Map<String, Integer> votes = new HashMap<>();
    Scanner scanner = new Scanner(System.in);
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();
      int spaceIndex = line.indexOf(' ');
      if (spaceIndex == -1) {
        System.out.println("Некорректная строка: " + line);
        continue;
      }
      String name = line.substring(0, spaceIndex);
      // vtSt = line.substring(7) = символы от индекса 7 до конца строки
      // то же самое, что line.substring(7, line.size())
      // vtSt = "10"
      String voteStr = line.substring(spaceIndex + 1);
      // превратим строку voteStr в число vote
      int vote = Integer.parseInt(voteStr);
      //int oldValue = votes.get(name); // для нового имени вернёт null
      int value = votes.getOrDefault(name, 0); // для нового имени вернёт 0
      System.out.println(" value: " + value + " + " + vote);
      value += vote;
      votes.put(name, value);
      //for (String line = scanner.nextLine(); line = scanner.nextLine()) {
      for (Map.Entry<String, Integer> result : votes.entrySet()) {
        name = result.getKey();
        vote = result.getValue();
        System.out.println(name + " " + vote);
      }
    }
  }
}
