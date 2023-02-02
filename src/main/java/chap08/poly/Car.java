package chap08.poly;

public class Car {

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
