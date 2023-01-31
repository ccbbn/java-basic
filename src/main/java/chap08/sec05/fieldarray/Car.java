package chap08.sec05.fieldarray;

public class Car {
    Tire[] tires = {
            new HankookTire(),
            new HankookTire(),
            new HankookTire(),
            new HankookTire()
    };

    void run() {
        for(Tire tire : tires) {
            tire.roll();
        }
    }
}
