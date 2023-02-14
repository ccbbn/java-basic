package chap14.ex01;

public class Lamda {
    public static void main(String[] args) {
        LamdaInter lamdaInter = new LamdaInter() {

            @Override
            public void cal(int x, int y) {
                System.out.println( x + y );

            }
        };

       action(new LamdaInter() {
           @Override
           public void cal(int x, int y) {
               System.out.println(x + y);
           }
       });

        // 오직 추상 메서드 1개 일 때만 람다 사용 가능, 람다식에서 익명구현 객체 결과 바꿈
        action((x, y) -> System.out.println(x * y));

    }

    public static void action(LamdaInter lamdaInter){
        int x = 10;
        int y =  4;
        lamdaInter.cal(x, y); // -> 람다식을 실행

    }
}

