package chap07.poly.ex5;

public class Driver {
    public void drive(Vehicle vehicle) {
        vehicle.run();
    }

    public void drive1(Taxi taxi) {
        taxi.run(); // 매개 변수 다형성 없이
    }


}