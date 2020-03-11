package tests;

import homework3.Person;
import homework3.Set;

public class HW3Test {

  public static void main(String[] args) {

      Person[] p = {new Person("Linda", "Smith", 34),
          new Person("Pilar", "J", 14),
          new Person("David", "Ess", 17),
          new Person("Mia", "Jackson", 61),
          null,
          new Person("Waverly", "Thames", 7),
          new Person("Carol", "Thomas", 28),
          new Person("Liam", "M", 82),
          null,
          new Person("Baltazar", "Ellison", 7),
          new Person("Manuel", "R", 14),
          new Person("David", "Ess", 17),
          new Person("Esma", "Lee", 45),
          new Person("Graham", "Monday", 49),
          new Person("Carol", "Thomas", 28)};

      Set<Person> s = new Set<>();
      for (Person per : p) {
          s.add(per);
      }

      System.out.println("Contents of the set: ");
      String[] strings = s.getStrings();
      for (String str : strings) {
          System.out.println(str);
      }

      Person youngest = s.getSmallest();
      System.out.println("\nYoungest Person Object: " + youngest);

      Person oldest = s.getLargest();
      System.out.println("\nOldest Person Object: " + oldest);

      Set<Person> x = s.lessThan(new Person("Nils", "Ell", 4));
      strings = x.getStrings();
      System.out.println("\nPerson objects younger than 4:");
      for (String str : strings) {
          System.out.println(str);
      }

      x = s.lessThan(new Person("Jane", "Smyth", 50));
      strings = x.getStrings();
      System.out.println("\nPerson objects younger than 50");
      for (String str : strings) {
          System.out.println(str);
      }

      x = s.greaterThan(new Person("Maxwell", "Tom", 100));
      strings = x.getStrings();
      System.out.println("\nPerson objects greater than 100");
      if (strings.length == 0) {
          System.out.println("Empty Set");
      } else {
          for (String str : strings) {
              System.out.println(str);
          }
      }

      x = s.greaterThan(new Person("Emma", "G", 34));
      strings = x.getStrings();
      System.out.println("\nPerson objects greater than 34");
      for (String str : strings) {
          System.out.println(str);
      }

      // Redefine the array of Person objects by removing null objects
      p = new Person[]{new Person("Linda", "Smith", 34),
          new Person("Pilar", "J", 14),
          new Person("David", "Ess", 17),
          new Person("Mia", "Jackson", 61),
          new Person("Waverly", "Thames", 7),
          new Person("Carol", "Thomas", 28),
          new Person("Liam", "M", 82),
          new Person("Baltazar", "Ellison", 7),
          new Person("Manuel", "R", 14),
          new Person("David", "Ess", 17),
          new Person("Esma", "Lee", 45),
          new Person("Graham", "Monday", 49),
          new Person("Carol", "Thomas", 28)};

      s = new Set<>();
      for (Person per : p) {
          s.add(per);
      }
      System.out.println("\n**************************************");
      System.out.println("\nContents of the set after removing null objects: ");
      strings = s.getStrings();
      for (String str : strings) {
          System.out.println(str);
      }

      youngest = s.getSmallest();
      System.out.println("\nYoungest Person Object: " + youngest);

      oldest = s.getLargest();
      System.out.println("\nOldest Person Object: " + oldest);

      x = s.lessThan(new Person("Nils", "Ell", 4));
      strings = x.getStrings();
      System.out.println("\nPerson objects younger than 4");
      if (strings.length == 0) {
          System.out.println("Empty Set");
      } else {
          for (String str : strings) {
              System.out.println(str);
          }
      }

      x = s.lessThan(new Person("Jane", "Smyth", 50));
      strings = x.getStrings();
      System.out.println("\nPerson objects younger than 50");
      for (String str : strings) {
          System.out.println(str);
      }

      x = s.greaterThan(new Person("Maxwell", "Tom", 100));
      strings = x.getStrings();
      System.out.println("\nPerson objects greater than 100");
      if (strings.length == 0) {
          System.out.println("Empty Set");
      } else {
          for (String str : strings) {
              System.out.println(str);
          }
      }

      x = s.greaterThan(new Person("Emma", "G", 34));
      strings = x.getStrings();
      System.out.println("\nPerson objects greater than 34");
      for (String str : strings) {
          System.out.println(str);
      }

      // Add additional Person objects to the Set object
      System.out.println("\n**************************************");
      System.out.println("\nAdd additional objects to the set: ");
      System.out.println("\nNumber of elements in the Set: " + s.size());
      System.out.println(s.add(null));
      System.out.println("\nNumber of elements in the Set: " + s.size());
      System.out.println(s.add(null));
      System.out.println("\nNumber of elements in the Set: " + s.size());
      System.out.println(s.add(new Person("Thomasina", "Zee", 2)));
      System.out.println("\nNumber of elements in the Set: " + s.size());
      System.out.println(s.add(new Person("Thomasina", "Zee", 2)));
      System.out.println("\nNumber of elements in the Set: " + s.size());
  }
}
