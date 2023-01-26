package chap06.gese;

public class Car {
    private String model;
    public static int fuel;

    public Car(String model, int fuel) {
        this.model = model;
        this.fuel = fuel;
    }

    public String getModel() {
        return model;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int fuel) {
        this.fuel = fuel;
    }
}
