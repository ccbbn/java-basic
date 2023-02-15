package chap16.ex04;

import access.p1.A;
import jdk.nashorn.internal.objects.NativeString;

import java.util.ArrayList;
import java.util.SplittableRandom;
import java.util.stream.Stream;

import static jdk.nashorn.internal.objects.NativeString.*;

public class FilterEx {
    public static void main(String[] args) {
        // 필터링, map, sorted로 중간처리
        ArrayList<String> list = new ArrayList<>();
        list.add("zoe");
        list.add("bob");
        list.add("Jane");
        list.add("John");
        list.add("zoe");

        Stream<String> stream = list.stream();
        System.out.println(stream.distinct().count());

        //이름이 4글자만
        Stream<String> stream1= list.stream();
        stream1.filter( name -> name.length() == 4 ).forEach(name -> System.out.println(name));

        //이름이 Z로 시작
        Stream<String> stream2= list.stream();
        stream2.filter( name -> name.startsWith("z") ).forEach(name -> System.out.println(name));

        //매핑
        list.stream().mapToInt( name -> name.length() ).forEach( n -> System.out.println(n));

        //문자열을 거꾸로, 첫 문자는 대문자로

        ArrayList<StringBuilder> newlist = new ArrayList<>();
        newlist.add(new StringBuilder("Zoe"));
        newlist.add(new StringBuilder("Bob"));
        newlist.add(new StringBuilder("Jane"));
        newlist.add(new StringBuilder("John"));

        Stream<StringBuilder> stream3 = newlist.stream();
        stream3.map(StringBuilder::reverse).map(stringBuilder -> stringBuilder.replace(0,stringBuilder.length(),toLowerCase(stringBuilder))).
                map(stringBuilder -> stringBuilder.replace(0,1,toUpperCase(stringBuilder.charAt(0)))).
                forEach(System.out::println);


        // eee -> e, e, e
        //list.stream().flatMap();

        // {50, 20, 30, 40 10}




    }

}
