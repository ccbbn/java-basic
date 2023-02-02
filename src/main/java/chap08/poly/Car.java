package chap08.poly;

public class Car {
    //타이어 인터페이스 배열에 특정 회사의 타이어 개체를 넣음
    //인터페이스를 활용한 Car 클래스
    Tire[] tires = {
            new KumhoTire(),
            new KumhoTire(),
            new KumhoTire(),
            new KumhoTire()
    };


//    Tire tire1 = new HankookTire();
//    Tire tire2 = new HankookTire();
//    Tire tire3 = new HankookTire();
//    Tire tire4 = new HankookTire() ;

//    void run(){
//        tire1.roll();
//        tire2.roll();
//        tire3.roll();
//        tire4.roll();
//    }

    void run() {
        for (Tire tire : tires) {
            tire.roll();
        }
    }

}
