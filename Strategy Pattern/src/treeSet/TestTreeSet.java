package treeSet;

import java.util.*;

public class TestTreeSet
{
  public static void main(String[] args)
  {


    Person person= new Person("Suhani","Pandey",21);
    Person person1= new Person("Rajip","Paudyal",16);
    Person person2= new Person("Pramesh","Shrestha",40);

    List<Person> persons= new ArrayList<>(Arrays.asList(person,person1,person2));


    TreeSet<Person> treeSet= new TreeSet<>(new LastnameComparator());
    treeSet.addAll(persons);
    System.out.println(treeSet);



    TreeSet<Person> treeSet1= new TreeSet<>(new AgeComparator());
   treeSet1.addAll(persons);
    System.out.println(treeSet1);



  }
}
