package chap07.poly.ex8.absclass;

public class PhoneExample {
    public static void main(String[] args) {
        //Phone phone = new Phone(); (x) 추상클래스라 객체 생성 못함, 상속만 해주는 클래스

        SmartPhone smartPhone = new SmartPhone("홍길동");

        smartPhone.turnOn();
        smartPhone.internetSearch();
        smartPhone.turnOff();
    }
}
