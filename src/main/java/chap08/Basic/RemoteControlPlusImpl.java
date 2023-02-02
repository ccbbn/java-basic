package chap08.Basic;

public class RemoteControlPlusImpl implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("고객님이 원하는 채널을 킵니다");
    }

    @Override
    public void turnOff() {
        System.out.println("티비를 끈다+");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("볼륨은" + volume + "으로 자동 조정");

    }
}
