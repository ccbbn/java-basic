package chap01.exam01;

public class VariableScopeExample {
    public static void main(String[] args) {
        //변수는 유효범위가 있다.
        //변수는 선언된 블록 내에서만 사용이 가능하다.
        //블럭이 끝나면 소멸됨

        int var1 = 10;

        if(true){
            System.out.println(var1);
            int var2 = 20;
            System.out.println(var2);
            //System.out.println(var3); // var3이 블럭 밖이라 안됨
        }
        int var3 = 30;
        System.out.println(var1);
        System.out.println(var3);
        //System.out.println(var2); // 유효 범위 밖이라 안됨

        for(int i= 0; i< 10; i++){
            int var2=20;  // if절에 있는 var2와 다른 if임
            System.out.println(var2);
        }


    }
}
