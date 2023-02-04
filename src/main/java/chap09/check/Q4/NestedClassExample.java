package chap09.check.Q4;

import chap07.poly.ex1.E;

public class NestedClassExample {
    public static void main(String[] args) {
        Car myCar = new Car();

        Car.Tire tire = myCar.new Tire(); // Tire tire = new Tire();의 양 변에 myCar 붙임

        Car.Engine engine = new Car.Engine();  // 스태틱이라 Car클래스에서 바로 Engine 클래스로 접근



    }
}
