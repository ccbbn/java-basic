package chap09.ex06;

import access.p1.A;

public class AnonymousEx {
    public static void main(String[] args) {

        Anonymous annoy = new Anonymous();

        //익명 객체 필드 사용
        annoy.field.wake();

        //익명 객체 로컬 변수 사용
        annoy.method1();

        //익명 개체를 매개값으로 사용
        annoy.method2(
                new Person(){

                    void study(){
                        System.out.println("공부합니다");
                    }

                    @Override
                    void wake() {
                        System.out.println("8시 기상");
                        study();
                    }
                }

        );

    }
}
