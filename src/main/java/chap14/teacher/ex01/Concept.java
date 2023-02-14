package chap14.teacher.ex01;

public class Concept {
    public static void main(String[] args) {
        // 익명 구현 객체
        Calculable calculable1 = new Calculable() {
            @Override
            public void calculate(int x, int y) {
                System.out.println(x + y);
            }
        };

        // 익명 구현 객체
        action(new Calculable() {
            @Override
            public void calculate(int x, int y) {
                System.out.println(x + y);
            }
        });
        // 람다식 : 추상 메서드 정의 (추상 메서드가 오직 하나일 때만 람다식을 적용 가능)
        action((x, y) -> System.out.println(10 * x * y));
    }

    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x, y);
    }
}
