package chap15.map;

import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.TreeSet;


// 저장과 동시에 정렬이된다
// 다만, 정렬의 기준이 필요
//
public class TreeEx {
    public static void main(String[] args) {
        TreeSet<Integer> scores  = new TreeSet<>();
        scores.add(new Integer(85));
        scores.add(new Integer(90));
        scores.add(new Integer(50));
        scores.add(new Integer(20));
        scores.add(new Integer(10));


        NavigableSet<Integer> descendingSet = scores.descendingSet();
        System.out.println(descendingSet.first());



        scores.first(); // 작은수, 오름차순 기준
        scores.last();
        scores.lower(50);
        scores.floor(50);


        while (!scores.isEmpty()){
            System.out.println(scores.pollFirst());
        }
    }
}
