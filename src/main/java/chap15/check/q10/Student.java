package chap15.check.q10;

import lombok.AllArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
public class Student implements Comparable<Student>{  // Student 타입과 비교
    public String id;
    public int score;


    @Override
    public int compareTo(Student o) {
        if( this.score > o.score) return 1; // 현재 내가 다음 값보다 크면 우측
        else if ( this.score == o.score) return 0;
        else return -1;

    }
}
