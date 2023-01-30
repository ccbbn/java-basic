package chap07.poly.ex8.absmethod;

public class AnimalExample {
    public static void main(String[] args) {

        Animal aa = new Dog();
        aa.breathe(); // 추상이지만 형변환은 가능
        aa.sound();


        Dog dog = new Dog();
        Cat cat = new Cat();
        dog.sound();
        cat.sound();
        System.out.println("-----");

        //변수의 자동 타입 변환
        Animal animal = null;
        animal = new Dog();
        animal.sound();
        animal = new Cat();
        animal.sound();
        System.out.println("-----");

        //매개변수의 자동 타입 변환
        animalSound(new Dog());
        animalSound(new Cat());
    }

    public static void animalSound(Animal animal) {
        animal.sound();
    }
}