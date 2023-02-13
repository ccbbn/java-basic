package chap15.comparable;

import chap15.map.TreeEx;

import java.util.TreeSet;

public class ComparableEx {
    public static void main(String[] args) {
        TreeSet<Person> people = new TreeSet<>();
        people.add(new Person("Zoe",23));
        people.add(new Person("jason",33));
        people.add(new Person("Steve",50));

        System.out.println(people.first().getName());



    }
}
