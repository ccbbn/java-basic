package chap08.poly.ex2;

import chap07.poly.ex1.B;
import chap07.poly.ex1.D;

public class Excute {
    public static void main(String[] args) {

        Driver driver = new Driver();


        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus);


        Vehicle bus1 = new Bus();
        Vehicle taxi1 = new Taxi();

        Vehicle vehicle1 = new Bus();


        //인터페이스에 없고 버스에만있느 메소드는 강제 타입변환으로 가져와야 함
        ((Bus)bus1).check();
        ((Bus)taxi1).check(); // 근본이 달라서 안됨

        if (vehicle1 instanceof Bus) {
            ((Bus)vehicle1).check();
        }
        driver.drive(vehicle1);

    }
}
