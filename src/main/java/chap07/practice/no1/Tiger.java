package chap07.practice.no1;

public class Tiger extends Carnivore {

    public Tiger(int stamina) {
        setStamina(stamina);
        setName("호랑이");
    }

    public void mimic(Herbivore herbivore) {
        herbivore.sound();
    }

    @Override
    public void eat() {
        System.out.println("호랑이가 먹습니다.");
    }

    @Override
    public void sleep() {
        System.out.println("호랑이가 잠을 잡니다.");
    }

    @Override
    public void sound() {
        System.out.println("크앙");
    }
}
