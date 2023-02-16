package chap13generic.ex01;

public class GenericBasic {
    public static void main(String[] args) {




        Car<Tire> car = new Car<>(); // Tire 타입으로 , Car클래스가 타이어 타입됨
        Car<Handle> car1 = new Car<>(); // Handle 타입으로
        Car<String> car2 = new Car<>();
        Car car3 = new Car(); // 디폴트로 오브젝트 타입

        ((Tire)car.parts).roll(); // 너무 불편

        car.parts.roll();
        car1.parts.handle();
        car3.parts.equals("");

        car.getParts().roll();
        car.setParts(new Tire());


    }
}
