package chap07.practice.no1;

public class Zoo {
    public static void main(String[] args) {

        // 사파리
        Animal[] anmials = new Animal[5];

        Carnivore carnivore = new Tiger(70);
        Herbivore herbivore = new Deer(60);



        // 호랑이일 경우 흉내내기를 먼저하고 사냥
        if (carnivore instanceof Tiger) {
            ((Tiger) carnivore).mimic(herbivore);
        }
        if (carnivore.hunt(herbivore)) {
            System.out.println(carnivore.getName() + " 사냥 성공!!");
        }

    }
}

