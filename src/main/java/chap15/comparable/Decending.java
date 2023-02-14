package chap15.comparable;

import chap15.set.Member;

import java.util.Comparator;

public class Decending implements Comparator<Member> {
    @Override
    public int compare(Member o1, Member o2) {
        if (o1.age < o2.age) { return 1;}
        else if (o1.age == o2.age) { return 0;}
        else return -1;

    }
}
