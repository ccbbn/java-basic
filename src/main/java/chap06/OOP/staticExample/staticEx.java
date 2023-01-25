package chap06.OOP.staticExample;

public class staticEx {
    public static void main(String[] args) {
        System.out.println(Cal.plusStatic(1, 2)); //바로 가져옴
        System.out.println(Cal.minus(1, 2));
        System.out.println(Cal.pi);
        // new로 객체만들면 인스턴스화 되는 것


        Cal cal = new Cal();
        cal.nonStaticMethod();



    }
}
