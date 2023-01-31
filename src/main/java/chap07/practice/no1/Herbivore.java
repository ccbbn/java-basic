package chap07.practice.no1;

public abstract class Herbivore extends Animal {
     public void flee() {
          System.out.println(this.getName() + "이 도망갔습니다.");
     };
}
