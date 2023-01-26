package chap06.gese;

public class CarTest {


    public static void main(String[] args) {
        Car car = new Car("audi", 100);
        System.out.println(car.getModel());
        System.out.println(car.getFuel());
        car.setFuel(500);
        System.out.println(car.fuel);



    }
}
