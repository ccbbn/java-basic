package chap06.OOP;

import java.lang.reflect.AnnotatedWildcardType;

public class ClassBasicExample { // 실행클래스, 라이브러리 클래스
    public static void main(String[] args) {
        // 클래스 선언: 객체 생성을 위한 설계도 작성
        // [클래스 타입] [변수명] = new [클래스 타입](); 생성자를 호출함
        Car a6 = new Car(); // 개체는 힙영역에 생성됨, a6가 스택영역에서 객체를 가리킴(참조값을 들고 있음)
       // System.out.println(a6); // 주소가 나옴, 객체는 자동으로 Object클래스를 상속 받음.. a6.getClass  a6.equals
        Car g70 = new Car();

        Car a5 = new Car("Audi", 0, carType.DISEL, "WHITE",
                300, "a5", 2003, new Tire(), new Engine());
        System.out.println(a5.tire);

        Car a55 = new Car("audi", new Tire());

        Tire t1 = new Tire(company.NEXEN, 10 ,10);
        System.out.println(t1.company);

        Tire t2 = new Tire(10, 10);
        System.out.println(t2.size);

        a5.run();
        a5.gasUp(100);
        a5.run();

        System.out.println(Car.pi);




/*
        inCar(a6,"audi", 0, carType.DISEL, "white", 300,
                "a6", 2023, new Tire(), new Engine());
    }
    static void inCar(Car car, String company, int accidents, carType carType, String color,
               int maxSpeed, String model, int year, Tire tire, Engine engine){
        car.company = company; // 객체를 직접 초기화
        car.accidents = accidents;
        car.carType = carType; // ENUM
        car.color = color;
        car.maxSpeed = maxSpeed;
        car.model = model;
        car.year = year;
        car.tire = new Tire();  // 객체 초기화를 또 다른 클래스로 함
        car.engine = new Engine();
     */
    }

}
