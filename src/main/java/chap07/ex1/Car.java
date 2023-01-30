package chap07.ex1;

public class Car {

    String model;
    int fuel;

    public Car(){}

    public Car(String model, int fuel) {
        this.model = model;
        this.fuel = fuel;
    }

    public void go(){
        System.out.println("차가 간다");
    }


    public void stop(){
        System.out.println("차가 멈춤");
    }
}
