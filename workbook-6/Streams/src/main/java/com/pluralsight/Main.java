package com.pluralsight;

import javax.swing.*;
import java.util.*;

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
        List<Person> results = new ArrayList<>();
        for(Person p : people){
            if( p.getFullName().contains(name))
                results.add(p);
        }
        int sum = 0;
        for(Person p : people)
            sum+=p.getAge();

        int avg = sum/people.size();

        results.forEach(System.out::println);

        System.out.println("Average age: "+avg);
        people.sort(Comparator.comparing(Person::getAge));
        System.out.println("Youngest: "+people.get(0));
        System.out.println("Oldest: "+people.get(people.size()-1));
    }
}
