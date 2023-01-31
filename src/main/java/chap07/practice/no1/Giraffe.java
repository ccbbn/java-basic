package chap07.practice.no1;

public class Giraffe extends Herbivore {

    public Giraffe(int stamina) {
        setStamina(stamina);
        setName("기린");
    }

    @Override
    public void eat() {
        System.out.println("기린이 먹습니다.");
    }

    @Override
    public void sleep() {
        System.out.println("기린이 잠을 잡니다.");
    }

    @Override
    public void sound() {
        System.out.println("기린~기린~");
    }
}
