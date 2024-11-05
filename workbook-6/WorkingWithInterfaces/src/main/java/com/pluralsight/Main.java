package com.pluralsight;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Person> myFamily = new ArrayList<>();
        myFamily.add( new Person("Dana", "Wyatt", 63) );
        myFamily.add( new Person("Zachary", "Westly", 31) );
        myFamily.add( new Person("Elisha", "Aslan", 14) );
        myFamily.add( new Person("Ian", "Auston", 16) );
        myFamily.add( new Person("Ian", "Auston", 18) );
        myFamily.add( new Person("Zephaniah", "Hughes", 9) );
        myFamily.add( new Person("Ezra", "Aiden", 17) );
        myFamily.add( new Person("Ashley", "Aiden", 18) );
        myFamily.add( new Person("Jacob", "Aiden", 17) );

        Comparator<Person> compByLastName = (Person e1,Person e2) -> e1.getLastName().compareTo(e2.getLastName());

        Collections.sort(myFamily,compByLastName);
        for (Person p : myFamily)
            System.out.println(p);
    }
}
