package chap06.OOP.staticExample;

public class Cal {
    // 멤버의 특성에 따라 static 키워드를 붙임
    static final double pi;


    // 인스턴스 필드는 언제 생성?
    // 객체를 생성한 후에 사용 가능
    // new 생성이 반드시 필요!
    int n1;


    static {
        pi = 3.14;
        //n1; 인스턴스 필드는 접근 불가
    }


    static int plusStatic(int n1, int n2) {
        System.out.println(pi);
        //System.out.println(this.n1); 인스턴스는 객체가 필요함
        return n1 + n2;
    }
    static int minus(int n1, int n2) {
        return n1 - n2;
    }
    // 인스턴스 메소드

    public void nonStaticMethod() {
        System.out.println(pi);
        System.out.println(plusStatic(1, 2));
        minus(1, 2);
    }

}
