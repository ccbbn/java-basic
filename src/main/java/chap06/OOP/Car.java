package chap06.OOP;

public class Car {
    // 필드, 메소드로 객체 모델링
    String company;
    String model;
    String color;
    int maxSpeed;
    int year;
    int accidents;
    carType carType;
    int speed;
    int rpm;
    Engine engine;
    Tire tire;

    Car(){};


    public Car( String company, int accidents, carType carType, String color,
                      int maxSpeed, String model, int year, Tire tire, Engine engine){
        this.company = company; // 객체를 직접 초기화
        this.accidents = accidents; // ENUM
        this.carType = carType;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.year = year;
        this.tire = tire;  // 객체 초기화를 또 다른 클래스로 함
        this.engine = engine;

    }
}

