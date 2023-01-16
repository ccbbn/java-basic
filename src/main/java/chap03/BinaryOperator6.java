package chap03;

public class BinaryOperator6 {
    public static void main(String[] args) {
        //증산시논비
        // 논리 연산자
        // 피연산자가 true or false :boolean
        // && ||

        int code = 'A'; // 'A' = 65
        System.out.println(code >= 65);
        //&& 연산자는 false를 만나면 뒤에 피연산자를 검증하지 않는다
        // false로 끝나면 이전까지는 다 나와야함

        if(f2()&&f3()&&f1()){
        } //f2f3f1 전부

        if(f2()||f1()){
        } // f2만 나옴, true 나왔으니 뒤룰 볼 필요가 없음


        //xor
        System.out.println(true^false);
        //not
        System.out.println(!true);


    }
    public static boolean f1(){
        System.out.println("f1호출됨");
        return false;
    }

    public static boolean f2(){
        System.out.println("f2호출됨");
        return true;
    }

    public static boolean f3(){
        System.out.println("f3호출됨");
        return true;
    }


}
