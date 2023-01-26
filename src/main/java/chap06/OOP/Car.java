package chap06.OOP;

import lombok.Getter;
import lombok.Setter;




public class Car {
    // 필드, 메소드로 객체 모델링
    // 필드 + 메소드: 멤버
    // 멤버: 인스턴스 멤버 vs 정적(static) 멤버
        // 인스턴스: new로 생성산 객체
        //

    static double pi = 3.14;   //정적 멤버, 클레스에서 바로 접근(객체 필요없이 사용), 변하지 않음,

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
    int fuel;



    // 기본 생성자
    // 매개변수를 달리해서 생성자를 여러 개 선언하는 것 : 생성자 "오버로딩"


    public Car() {};

    public Car(String company, int accidents, carType carType, String color,
                      int maxSpeed, String model, int year, Tire tire, Engine engine){
        // 객체를 초기화
        this.company = company;
        this.accidents = accidents;
        this.carType = carType;
        this.color = color;
        this.maxSpeed = maxSpeed;
        this.model = model;
        this.year = year;
        this.tire = tire;  // 객체 초기화를 또 다른 클래스로 함
        this.engine = engine;

    }
    public Car(String company, Tire tire) {
        this.company = company;
        this.tire = tire;
    }

    // 객체와 동작 : 메소드
    // 다른 객체와 상호작용
    public boolean run() {
        if ( fuel > 0) {
            System.out.println(this.model + "이 운행한다");
            fuel--;
            return true;
        } else {
            System.out.println("연료가 모자름, 가까운 주유소에 방문하세요");
            return false;

        }
    }

    public int gasUp(int fuel) {
        this.fuel += fuel;
        return this.fuel;
    }
    public void method() {
        run();
        gasUp(110);
    }

    public int getterFuel() {
        return fuel;
    }

    public void setterFuel(int fuel) {
        if ( fuel < 0 ) {
            return;
        }
        this.fuel = fuel;
    }
}

