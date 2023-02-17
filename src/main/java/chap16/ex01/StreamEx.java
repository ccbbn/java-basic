package chap16.ex01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {

        // 스트림 적용 대상
        // 스트림은 필터만 하고 끝내지 않고, 최종처리가 반드시 필요

        Set<String> set = new HashSet<>();
        set.add("john");
        set.add("zoe");
        set.add("steve");


        for (String name : set){
            System.out.println(name);
        }

       Iterator<String> iterator = set.iterator();
        while ((iterator.hasNext())){
            System.out.println(iterator.next());
        }


        Stream<String> stream = set.stream();
        stream.forEach( name -> System.out.println(name)); // 괄호 안에 람다식
    }


}
