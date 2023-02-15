package chap16.ex02;

import java.util.ArrayList;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StudentEx {
    public static void main(String[] args) {
    // 기본 자료구조를 스트림들로 바꿔서 매번 다르게 사용할 수 있음
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("zoe",90));
        list.add(new Student("bob",85));
        list.add(new Student("chris",75));
        list.add(new Student("steve",95));
        list.add(new Student("c",90));

        // forEach() : 최종처리 메소드

        Stream<Student> stream = list.stream();
        // 맵핑 : 기존의 데이터를 다른 것으로 바꿈  OptionalDouble: Double의 또 다른 형태
//        OptionalDouble average = stream.mapToInt(student -> student.getScore())
//                .average();
//        System.out.println("평균 : " + average);
//        System.out.println("평균 : " + average.getAsDouble());
//
//        long count =  stream.mapToInt(student -> student.getScore())
//                .count();

        IntStream intStream = stream.mapToInt(student -> student.getScore());
        OptionalDouble average2 = intStream.average();
        System.out.println(average2 + "합체");

    }
}
