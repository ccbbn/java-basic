package chap08.Basic;

public interface RemoteControl {
//추상 클래스랑 비슷
//우리는 동작에 관심있다
//    String name; 인터페이스는 불가
//    int birth; 인터페이스느 불가

    final static int MAX_VOLUME = 10; // final static 상시 적용


    abstract void turnOn(); // abstract 상시 적용, {}를 못갖음
    void turnOff();
    void setVolume(int volume);

    // defalut를 쓰면 메소드에 {}를 갖을 수 있음, 구현 객체에서 이 메소드를 사용가능
    default void setMute (boolean mute) {
        if (mute) {
            System.out.println("무음");
        } else {
            System.out.println("소리");
        }
    }

    // 스테틱 메소드도 {} 갖으며, 바로 사용 가능
    static void chargeBattery(){
        System.out.println("건전지를 교환합니다");
    }









}
