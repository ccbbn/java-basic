package chap07.poly.ex5;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();

        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus);  // 원래 Vehicle 타입의 매개변수가 들어가야 하지만 bus가 상속 받아서 들어갈 수 있음
        driver.drive(taxi);
        driver.drive1(taxi); // 매개변수의 다형성 없이
    }
}