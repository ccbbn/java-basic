package chap08.Basic;

public class Audio implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("오디오를 킴");
    }

    @Override
    public void turnOff() {
        System.out.println("오디오 끔");
    }

    @Override
    public void setVolume(int volume) {

    }

}
