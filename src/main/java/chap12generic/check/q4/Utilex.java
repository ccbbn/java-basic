package chap12generic.check.q4;

import chap08.Basic.Child;

import javax.swing.*;

public class Utilex {
    public static void main(String[] args) {

        Pair<String, Integer> pair = new Pair<>("홍길동", 35);
        Integer age = Util.getValue(pair, "홍길동");
        System.out.println(age);


        ChildPair<String, Integer> childPair= new ChildPair<>("홍삼원", 35);
        Integer childAge = Util.getValue(childPair, "홍삼순");
        System.out.println(childAge);




    }
}