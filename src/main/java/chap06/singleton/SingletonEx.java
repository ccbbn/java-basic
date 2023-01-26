package chap06.singleton;

public class SingletonEx {
    public static void main(String[] args) {
        // 클래스를통해 객체를 만듦
        // 객체 == 인스턴스
        // 클래스를 통해서 객체를 무한히 생성
        // 오직 1개의 개체만 생성을 원한다면
        // 싱글톤을 사용

        // 객체 생성
        Singleton singleton = Singleton.getInstance(); // 싱글톤 클래스의 매소드 getInsance ( 이 메소드는 내부에 한 개만 생성된 객체를 받음)


        singleton.a =10;



    }
}
