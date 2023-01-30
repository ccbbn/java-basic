package chap07.poly.ex8.absmethod;

public abstract class Animal {
    public String kind;

    public void breathe() {
        System.out.println("숨을 쉽니다.");
    }

    public abstract void sound(); // {} 실행 블록이 없음, 상속받는 자식들은 sound() 메소드를 반드시 구현
}

