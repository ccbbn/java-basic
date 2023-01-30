package chap07.protec.pc1;

public class B {
    public void method() {
        A a = new A();
        a.field = "hello";
        a.method();;
        //프로텍트로 모두 접근
    }
}
