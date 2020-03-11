package homework3;

public class Person implements Comparable<Person> 
{
  private String firstName;
  private String lastName;
  private int age;
  
  public Person(String firstName, String lastName, int age) 
  {
    this.firstName = firstName;
    this.lastName = lastName;
    this.age = age;
  }
  
  public String getFirstName() 
  {
    return firstName;
  }
  
  public void setFirstName(String firstName)
  {
    this.firstName = firstName;
  }
  
  public String getLastName() 
  {
    return lastName;
  }
  
  public void setLastName(String lastName) 
  {
    this.lastName = lastName;
  }
  
  public int getAge() 
  {
    return age;
  }
  
  public void setAge(int age) 
  {
    this.age = age;
  }
  
  @Override
  public String toString() 
  {
    return "firstName: " + firstName + " lastName: " + lastName + " age: " + age;
  }
  
  @Override
  public boolean equals(Object obj) 
  {
    boolean flag = false;
    if (obj != null && getClass() == obj.getClass()) 
    {
      if (this == obj)
      {
        flag = true;
      } 
      else 
      {
        Person other = (Person) obj;
        flag = age == other.age && firstName.equals(other.firstName) && lastName.equals(other.lastName);
      }
    }
    return flag;
  }
  
  public int compareTo(Person p) 
  {
    return age - p.age;
  }
}// end class
