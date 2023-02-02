package chap08.Basic;

import access.p1.A;

public class Excute {
    public static void main(String[] args) {
        // 클래스 : 객체 생성 가능
        // 인터페이스도 추상클래스처럼 인스턴스를 만들 수 없음

        new Child(); //
        new RemoteControlBasicImpl(); //

        RemoteControl rc = new RemoteControlBasicImpl();
        //RemoteControl rc = new RemoteControlPlusImpl();
        //RemoteControl rc = new Audio();

        rc.turnOn();
        rc.setMute(false); //인터페이스에 있는 애
        rc.setVolume(10);
        rc.turnOff();

        RemoteControl.chargeBattery(); // 인터페이스에서 바로 가져옴


        // 인터페이스로 받는 익명 객체, 1회성
        new RemoteControl() {
            @Override
            public void turnOn() {

            }

            @Override
            public void turnOff() {

            }

            @Override
            public void setVolume(int volume) {

            }
        };

        // 다중인터페이스
        Smart smartTv = new SmartTv();  // Smart 인터페이스만 있는 것만 실행, SmartTv의 객체가 Smart인터페이스 타입으로변환
        RemoteControl smartTv1 = new SmartTv(); // RemoteControl 인터페이스만 있는 것만 실행

        ((Smart)smartTv).search("www.www.net"); // SmartTv에는 없지만 Smart에 있는 것을 실행, 강제 형변환

    }
}
