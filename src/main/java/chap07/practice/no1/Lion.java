package chap07.practice.no1;

public class Lion extends Carnivore {

    public Lion(int stamina) {
        setStamina(stamina);
        setName("사자");
    }

    @Override
    public void eat() {
        System.out.println("사자가 먹습니다.");
    }

    @Override
    public void sleep() {
        System.out.println("사자가 잠을 잡니다.");
    }

    @Override
    public void sound() {
        System.out.println("크앙");
    }
}