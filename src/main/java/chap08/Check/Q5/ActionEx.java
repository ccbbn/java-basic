package chap08.Check.Q5;

public class ActionEx {
    public static void main(String[] args) {

        // 익명 구현 객체는 인터페이스로 바로 만든다 ,구현클래스 패스하고 바로 만듦
        Action action = new Action() {
            @Override
            public void work() {
                System.out.println("복사를 원함");
            }
        };
        action.work();

    }
}
