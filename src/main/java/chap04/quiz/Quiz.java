package chap04.quiz;

import java.sql.SQLOutput;
import java.util.SortedMap;

public class Quiz {
    public static void main(String[] args) {
        //1. 무작위 랜덤 숫자 0~100 사이의 값을 변수에 대힙

        int n;

        n = (int)(Math.random()*100)+1;
        System.out.println(n);

        //2. 해당 숫자가 90이상이면 "90~100 사이의 값입니다" 라는 메시지
        //   해당 숫자가 80이상이면 "80~89 사이의 값입니다" 라는 메시지
        //  ....
        //   해당 숫자가 0이상이면 "0~9 사이의 값입니다" 라는 메시지
        //if문 사용
        //switch도 해보자


        if (n>=90) {
            System.out.println("90~100");
        } else if (n>=80) {
            System.out.println("89~80");
        } else if (n >=70) {
            System.out.println("79~80");
        }else{
            System.out.println("나머지");
        }
        /*
        String m = "";
        if (n>=90) {
            m = "90이상";
        } else if (n>=80) {
            m = "80이상";
        } else if (n >=70) {
            m = "70이상";
        } else{
            System.out.println("나머지");
        }
        
        switch (m){
            case "90이상":
                System.out.println("90~100");
                break;
            case "80이상":
                System.out.println("80~89");
                break;
            case "70이상":
                System.out.println("79~80");
                break;
            case "나머지":
                System.out.println("나머지");
                break;
        }*/

        int k = n/10;
        switch (k){
            case 10 :
            case 9 :
                System.out.println("90~100");
                break;
            case 8 :
                System.out.println("80~89");
                break;
            case 7 :
                System.out.println("70~79");
            default:
                System.out.println("나머지");

        }


        
        
        
        
        
        
        
        
        
        
    }


}
    

