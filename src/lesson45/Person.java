package lesson45;

import java.util.Objects;

public class Person {

  private String name;
  private String lastName;
  private int age;

  public Person(String name, String lastName, int age) {
    this.name = name;
    this.lastName = lastName;
    this.age = age;
  }

  public String toString() {
    return name + " " + lastName + " (age: " + age + ")";
  }

  @Override
  public boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
//    if (this.getClass() != obj.getClass()) {
//      return false;
//    }
    if (!(obj instanceof Person otherPerson)) {
      return false;
    }

    Person person = (Person) obj;
    return name.equals(otherPerson.name) &&
        lastName.equals(otherPerson.lastName) &&
        (age == otherPerson.age);
  }

  @Override
  public int hashCode() {
    return name.hashCode() * lastName.hashCode() * age;
  }
}
