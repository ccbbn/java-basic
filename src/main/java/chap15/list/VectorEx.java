package chap15.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class VectorEx {

    static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {



        List<Board> boards = new Vector<>();
        boards.add(new Board("해리포터", "해리야 힘내", "jk롤링"));
        boards.add(new Board("반지의 제왕", "골룸", "뉴구"));

        System.out.println(boards.get(0).getContent());
        System.out.println(boards.get(1).getContent());
    }




    boolean Thread() {
        // 멀티 스레드
        //작업1

        List<Vector> list = new Vector<>();
        //작업 2

        while (true) {
            switch (new Scanner(System.in).next()) {
                case "1":
                case "2":

            }
            return false;
        }
    }
}
