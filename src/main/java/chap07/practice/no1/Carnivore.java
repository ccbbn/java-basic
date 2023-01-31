package chap07.practice.no1;

public abstract class Carnivore extends Animal {
    public boolean hunt(Herbivore herbivore) {
        if (herbivore.getStamina() > this.getStamina()) {
            herbivore.flee();
            return false;
        }
        return true;
    }
}
