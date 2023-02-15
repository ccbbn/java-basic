package chap16.ex02;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Student implements Comparable<Student>{

    String name;
    int score;

    @Override
    public int compareTo(Student o) {
        if( this.score > o.score) return -1;
        else if (this.score == o.score) return 0;
        else
            return 1;
    }
}
