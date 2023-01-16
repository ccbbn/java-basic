package chap04.while_statement;

public class while_statement {
    public static void main(String[] args) {
        // 1번 실행
        if(true){
            System.out.println("if다");

        }

        //1 1번 이상 실행
        //반듸 종료 조건이 있어야 한다.
        //반복문이 종료할 수 있는 방법: break, return, while(false)
        /*while (true){
            System.out.println("while다");
        //return; : main 메서드에서 나감
        // break; : while 문에서 나감 */

        int i = 0;
        /*
        while(i < 5){
            System.out.println("루프");
            i ++ ;
          */

        while (true){
            System.out.println("루프2");
            i ++;
            if (i ==5){ break;}


            //int i = 0 <- 유효범위 주의
            int j =0 ;
        }
        int j=0;
        do {
            System.out.println("ㅎㅇ");
            j++;
        }while (j<5);


    }
}
