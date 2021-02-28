
//https://www.youtube.com/watch?v=FWoYpM-E3EQ
//Java Streams Tutorial

import java.util.*;
import java.util.stream.Collectors;

class Main{
    public static void main(String[] args){
        
        List<Person> people = new ArrayList<>();

        people.add(new Person("Warren Buffett", 120));
        people.add(new Person("Jeff Bezos", 150));
        people.add(new Person("Bill Gates", 100));
        people.add(new Person("Mark Zuckerberg", 50));

        /* Stream Method */
        List<Person> hundredClub = people.stream()
            .filter(person -> person.billions >= 100)
            .collect(Collection.toList());

        /* Stream Method Sort */
        // List<Person> hundredClub = people.stream()
        //     .sorted(Comparator.comparing(person -> person.name))
        //     .collect(Collection.toList());

        /* Stream Combined Method */
        List<Person> hundredSortedClub = people.stream()
            .filter(person -> person.billions >= 100)
            .sorted(Comparator.comparing(person -> person.name))
            .collect(Collection.toList());

        /* Traditional Method -- loop through the array to get the person */
        // List<Person> hundredClub = new ArrayList<>();
        // for(Person p : people){
        //     if(p.billions >= 100){
        //         hundredClub.add(p);
        //     }
        // }

        // print out the person name
        // hundredClub.forEach(person -> System.out.println(person.name));
        hundredSortedClub.forEach(person -> System.out.println(person.name));
    }

    static class Person{
        String name;
        int billions;

        public Person(String name, int billions){
            this.name = name;
            this.billions = billions;
        }
    }
}