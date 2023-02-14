package chap15.comparable;

import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class Person implements Comparable<Person>{
    String name;
    int age;

    @Override
    public int compareTo(Person p) {
        if ( this.age < p.age) return -1;
        else if (this.age  == p.age ) return 0;
        else return 1;

        // 2진 트리에서 기준에서 왼쪽으로 갈지 오른쪽으로 갈지
    }

}
