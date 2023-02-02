package chap08.Basic;

public class RemoteControlBasicImpl implements RemoteControl{
    //RemoteControl의 구현 클래스  == 추상클래스의 자식

    private int volume; // 인터페이스에는 이거 못해서 여기에 해야함


    @Override
    public void turnOn() {
        System.out.println("티비킴");
    }

    @Override
    public void turnOff() {
        System.out.println("티비끔");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("볼륨은" + volume);

    }
}
