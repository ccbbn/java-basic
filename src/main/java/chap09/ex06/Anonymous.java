package chap09.ex06;

public class Anonymous {


////////필드 초기값으로 대입/////////////
    Person field = new Person() {
        void work() {
            System.out.println("출근합니다");
        }

        @Override
        void wake() {
            super.wake();
        }
    };
/////////필드를 선언하고 익명 개체로 초기화 완료/////////////

  void method1(){

      Person localVar = new Person(){
      };

  }








}
