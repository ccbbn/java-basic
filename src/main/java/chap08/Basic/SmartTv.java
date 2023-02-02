package chap08.Basic;

public class SmartTv implements RemoteControl, Smart{
    @Override
    public void turnOn() {
        System.out.println("스맛티비를 킴");
    }

    @Override
    public void turnOff() {
        System.out.println("스마트 티비 끔");

    }

    @Override
    public void setVolume(int volume) {
        System.out.println(volume + "너무 크다");


    }

    @Override
    public void search(String url) {
        System.out.println(url + "검핵합니다");

    }
}
