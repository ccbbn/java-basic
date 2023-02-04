package chap09.ex06;

public class Anonymous {


    ////////필드 선언과 초기값으로 입력/////////////
    Person field = new Person() {
        void work() {
            System.out.println("출근합니다");
        }

        @Override
        void wake() {
            System.out.println("6시에 일어납니다");
            work();
        }
    };
/////////필드를 선언하고 익명 개체로 초기화 완료, 로컬 변수값으로 대입/////////////

    void method1() {

        Person localVar = new Person() {

            void walk() {
                System.out.println("산책합니다");
            }

            @Override
            void wake() {
                System.out.println("7시에 일어납니다");
                walk();
            }
        }; //필드
        /////////////////////로컬변수 사용//////////////////////////
        localVar.wake();

    }
///////////////////매개변수///////////////////
    void method2(Person person) {
        person.wake();
    }
}










