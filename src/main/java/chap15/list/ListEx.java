package chap15.list;

import java.util.ArrayList;

public class ListEx {
    public static void main(String[] args) {
        int[] arr = new int[5];
        arr[0] = 1;


        // 어레이리스트 : 변경시 내부 배열복사

        // 링크드리스트 : 주소값으로 연결

        ArrayList<String> arrayList = new ArrayList<>();
        Integer integer11 = new Integer(11);
        String str = new String("hello");

        arrayList.add(str);
        arrayList.add(str);
        System.out.println(arrayList.size());

        str = null;

        System.out.println(str);
        System.out.println(arrayList.get(0));
        System.out.println(arrayList.get(1));

    }
}
