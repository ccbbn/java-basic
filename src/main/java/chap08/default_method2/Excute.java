package chap08.default_method2;

public class Excute {
    public static void main(String[] args) {

        // 부모인터페이스 추상 매소드와 C1의 추상메소드 소환
        ChildInter1 ci1 = new ChildInter1() {
            @Override
            public void method3() {
                System.out.println("C1의 추상메소드");
            }

            @Override
            public void method1() {
                System.out.println("난 부모에게 상속 받은 추상메소드");

                //c1안에 디폴트 메소드2없음, 하지만 상속때문에 부모 매서드에 있는 method2()에 접근가능
            }
        };

        ChildInter2 ci2 = new ChildInter2() {
            @Override
            public void method3() {
                System.out.println("난 인터페이스 C2의 추상 메소드");
            }

            @Override
            public void method1() {
                System.out.println("난 부모인터페이스에 있는 매소드1인데 c2가 상속 받았기 때문에 접근이 됨");
            }

            //c1안에 디폴트 메소드2없음, 하지만 상속때문에 부모 매서드에 있는 method2()에 접근가능
        };


        ChildInter3 ci3 = new ChildInter3() {
            @Override
            public void method2() {
                System.out.println("부모에게서 상속받은 디폴트 메소드를 인터페이스 c3이 추상 메소드로 재정했음");

            }

            @Override
            public void method3() {
                System.out.println("인터페이스c3의 추상 메소드");

            }

            @Override
            public void method1() {
                System.out.println("인터페이스c3이 부모인터페이스에서 상속을 받기 때문에 부모의 매소드1에 접근가능");
            }
        };
        // 추상메소드는 반드시 오버라이드, 그냥 메소드는 오버라이드 선택



    ci3.method2();
    ci3.method3();
    ci3.method1();
    }

}
