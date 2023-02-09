package chap11.ex04;

import chap08.Basic.Parent;

public class StringEx {
    public static void main(String[] args) {
        String str = new String("Hello World! Every one and I love you guys.");
        // 1. e가 몇개 있는지 확인하는 메소드, 출력까지
        // 2. 해당 문구를 5번 반복하는 메소드 호출
        // 3-1. 띄어쓰기 된거를 문자 "*"로 채우기
        // 3-2. 실행 후 새로운 문자열을 "*" 기준으로 나눠서 배열에 담아주세요




        findString("e");
        repeat(5); //2
        replace(" ","*"); //3-1
        makeArray();//3-2


        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e'){
                count++;
            }
        }

//
//        int place0 = str.indexOf('e');
//        int place1 = str.substring(place0 +1).indexOf('e');
//        int place2 = str.substring(place1+1).indexOf('e');



        int count1 =0;
        int[] place = new int[str.length()];
        int[] nplace = new int[str.length()];
        for (int i = 1; i < str.length(); i++){

            place[0] = str.indexOf('e');
            place[i] = str.substring((place[i-1] + 1)).indexOf('e');



        }

        for (int i = 0; i < place.length; i++){
            System.out.println(place[i]);
        }
    }




    static void findString(String string){
        String str = new String("Hello World! Every one and I love you guys.");
        System.out.println(str.length() - str.replace(string, "").length());}


    static void repeat(int rep){
        String str = new String("Hello World! Every one and I love you guys.");
        System.out.println(str.repeat(rep));
    }

    static void replace(String origin, String replacement) {
        String str = new String("Hello World! Every one and I love you guys.");
        System.out.println(str.replace(origin, replacement));
    }


    static String replaceReturn(String origin, String replacement) {
        String str = new String("Hello World! Every one and I love you guys.");
        return str.replace(origin, replacement);
    }

    static void makeArray(){
        String newString = (replaceReturn(" ","*"));
        String[] newArray = newString.split("\\*");

        for (int i = 0; i < newArray.length; i++){
            System.out.println(newArray[i]);
        }

    }


}


