package chap07.practice.no1;

public abstract class Animal {
    private int stamina;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        if (stamina > 100 || stamina < 0) {
            System.out.println("스태미너는 0 ~ 100 사이입니다.");
            return;
        }
        this.stamina = stamina;
    }

    public abstract void eat();
    public abstract void sleep();
    public abstract void sound();
    /*
    1. Animal 클래스와 Animal 클래스를 상속받는
    Carnivore 클래스와 Herbivore 클래스를 선언하세요
    (모두 추상 클래스로 선언하세요)
    - Animal 클래스는 추상클래스로 만들되 동물의 공통적인 속성인
    - 먹기(eat), 자기(sleep), 소리내기(sound) 메소드를 추상 메소드로 만들어 보세요
    - Carnivore 클래스는 hunt( ) 라는 메소드를 추가적으로 가지도록 하세요
        - boolean hunt(Herbivore herbivore)
    - Herbivore 클래스는 flee( ) 라는 메소드를 추가적으로 가지도록 하세요
        - flee( )

   2. Carnivore 클래스를 상속받는 육식동물 Lion, Tiger를 선언
    - 구현해야하는 모든 메소드를 오버라이드하세요.
    - System.out.println();
   3. Herbivore 클래스를 상속받는 초식동물 Giraffe, Deer를 선언
    - 구현해야하는 모든 메소드를 오버라이드하세요.
     */

    /*
        Animal 클래스에 필드를 선언하세요.
        - int stamina (스태미나)
        - 스태미나는 0~100 까지 값만 허용
     */

    /*
        hunt() 메소드에 로직을 구현하세요.
        - 사냥하는 육식동물의 스태미나가 초식동물의
          스태미나보다 높거나 같으면 사냥 성공 true
        - 사냥이 실패하면 해당 초식동물은 도망가고(flee() 호출) false 리턴

        hunt() 메소드의 결과값에 따라
        "육식동물이름"이 "초식동물이름" 사냥에 성공했습니다"

        혹은
        "육식동물이름"이 "초식동물이름" 사냥에 실패했습니다"
        출력

    */
}