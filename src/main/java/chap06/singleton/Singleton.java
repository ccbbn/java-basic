package chap06.singleton;

public class Singleton {

    int a;
    private static Singleton singleton = new Singleton(); // 싱글톤 객체를 클래스 내부에 먼저 생성


    private Singleton(){
    } // 외부에 생성을 못하도록 생성자를 Singleton 클래스에만 한정시킴

    public static Singleton getInstance(){
        return singleton;
    }






}
