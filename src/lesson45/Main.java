package lesson45;

import java.util.HashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
    Set<Person> students = new HashSet<>();
    //students.add(new Person("Alice", "Dow", 23));
    Person alice = new Person("Alice", "Dow", 23);
    students.add(alice);
    Person bob = new Person("Bob", "Dow", 24);
    students.add(bob);
    //students.add(alice); - одна и та же ссылка, вторая Алиса не создастся
    Person alice2 = alice;
    Person bob2 = new Person("Bob", "Dow", 24); //а тут всё хорошо, ссылки разные, значит, и объекты разные
    students.add(alice2);
    students.add(bob2);
    //System.out.println("bob2 = " + bob2);
    for (Person student : students) {
      System.out.println(student);
    }
    System.out.println("bob == bob2: " + bob.equals(bob2));
    System.out.println("alice == bob2: " + alice.equals(bob2));
  }
}
