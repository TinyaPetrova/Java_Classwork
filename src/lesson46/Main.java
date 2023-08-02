package lesson46;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

    Set<String> names = new HashSet<>();
    names.add("A");
    names.add("B");
    names.add("C");
    System.out.println(names);

    Map<String, Object> phonebook = new HashMap<>();
    phonebook.put("A", "+1");
    phonebook.put("B", "+2");
    phonebook.put("C", "+3");
    System.out.println(phonebook);
  }
}
