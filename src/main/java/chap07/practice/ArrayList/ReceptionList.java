package chap07.practice.ArrayList;

import java.util.InputMismatchException;
import java.util.Scanner;


public class ReceptionList {


    public static void main(String[] args) {



//        System.out.println(checkInputReception2(new Scanner(System.in)));

    }

    public static Object checkInputReception(String input) {
        boolean stayPage = true;
        Object output = null;

        while (stayPage) {
            try {
                switch (input) {
                    case "숫자입력":
                        output = new Scanner(System.in).nextInt();
                        stayPage = false;
                        break;
                    case "문자입력":
                        output = new Scanner(System.in).next().trim();
                        stayPage = false;
                        break;
                    case "양의정수입력":
                        output = new Scanner(System.in).nextInt();
                        if ((int) output < 0) throw new RangeInvalidException("음수는 불가");
                        stayPage = false;
                        break;
                    default:
                        System.out.println("checkInputReception()의 매개변수는 숫자입력, 문자입력, 양의정수입력");
                        stayPage = false;

                }
            } catch (InputMismatchException e) {
                switch (input) {
                    case "숫자입력":
                        System.out.println("숫자만 입력하세요");
                        break;
                    case "문자입력":
                        System.out.println("문자만 입력하세요");
                        break;
                    case "양의정수입력":
                        System.out.println("양의정수만 입력하세요");
                        break;
                }
            } catch (NullPointerException e) {
                System.out.println("널포인트이셉션");


            } catch (RangeInvalidException e) {
                String message = e.getMessage();
                System.out.println(message);
                System.out.println();
                e.printStackTrace();
            }

        }
        return output;
    }


//    public static <T> T checkInputReception2(T input) {
//        Object output = null;
//
//        if (input instanceof Integer) {
//            output = input;
//            System.out.println(output);
//        }else if (input instanceof String) {
//            output = input;
//            System.out.println(output);}
//
//        if ((int)input < 0)){
//
//            output = input;
//        }
//        return input ;
//    }
}


