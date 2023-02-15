package chap16.ex04;

import java.util.ArrayList;
import java.util.Comparator;

public class SortEx {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();

        list.add(new Student("zoe",90));
        list.add(new Student("bob",85));
        list.add(new Student("chris",75));
        list.add(new Student("steve",95));
        list.add(new Student ("tom",65));


        list.stream().sorted().forEach(student -> {
            System.out.println("이름 :" + student.getName());
            System.out.println("점수 :" + student.getScore());
        });  //Student 클래스를  Comparable<Student>로 구현객체를 만들고 오버라이딩 해서 정렬순서를 정의한다.
        list.stream().sorted(new Comparator<Student>() {
            // sorted에서 Comparator<Student>로 익명구현객체를 만들어서 정렬순서를 정의
            @Override
            public int compare(Student o1, Student o2) {
                return 0;
            }
        }).forEach(student -> {
            System.out.println("이름 :" + student.getName());
            System.out.println("점수 :" + student.getScore());
        });
    }





}
