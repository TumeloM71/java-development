package pluralsight;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John", "Doe", 30));
        people.add(new Person("Jane", "Smith", 25));
        people.add(new Person("Emily", "Johnson", 35));
        people.add(new Person("Michael", "Williams", 40));
        people.add(new Person("Sarah", "Brown", 28));
        people.add(new Person("David", "Jones", 45));
        people.add(new Person("Jessica", "Davis", 32));
        people.add(new Person("Daniel", "Miller", 22));
        people.add(new Person("Sophia", "Garcia", 27));
        people.add(new Person("James", "Martinez", 38));

        String name = JOptionPane.showInputDialog(null, "Type a name to search");
        List<Person> results = people.stream().filter( p -> p.getFullName().contains(name)).toList();

        int avg = people.stream().map(Person::getAge).reduce(0, Integer::sum)/people.size();

        int averageFromStreamMethod = (int) people.stream().mapToDouble(Person::getAge).average().orElse(0);
        results.forEach(System.out::println);

        System.out.println("Average age: "+avg);
        System.out.println("Average age calculated with streams: "+averageFromStreamMethod);
        int youngest =  people.stream().map(Person::getAge).reduce( (a, b) -> a < b ? a : b).orElse(0);
        System.out.println("Youngest: "+youngest);
        int oldest =  people.stream().map(Person::getAge).reduce( (a, b) -> a > b ? a : b).orElse(0);
        System.out.println("Oldest: "+oldest);
    }
}
