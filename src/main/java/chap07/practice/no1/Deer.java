package chap07.practice.no1;

public class Deer extends Herbivore {

    public Deer(int stamina) {
        setStamina(stamina);
        setName("사슴");
    }

    @Override
    public void eat() {
        System.out.println("사슴이 먹습니다.");
    }

    @Override
    public void sleep() {
        System.out.println("사슴이 잠을 잡니다.");
    }

    @Override
    public void sound() {
        System.out.println("deer~deer~");
    }
}

