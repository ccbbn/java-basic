package chap12generic.ex2;

import java.util.ArrayList;

public class Collection {
    public static void main(String[] args) {
        ArrayList<String > arraylist = new ArrayList<>(); // 문자열 배열

        arraylist.add("가나다");
        arraylist.add("라마바");
        arraylist.get(0);
        arraylist.get(1);

        ArrayList<Integer> arraylist1 = new ArrayList<>(); // 문자열 배열

        arraylist1.add(1);
        arraylist1.add(2);
        arraylist1.get(0);
        arraylist1.get(1);


        ArrayList<Object> arrayList2 = new ArrayList<>(); // 모든 애들



    }
}
