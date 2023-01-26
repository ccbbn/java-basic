package chap06.anno;


public class Service {
    @Anno
    public void method1() {
        System.out.println("실행");
    }
    @Anno("*")
    public void method2() {
        System.out.println("실행2");
    }


    @Anno(value = "&", number = 4)
    public void method3() {
        System.out.println("실행2");
    }


}
