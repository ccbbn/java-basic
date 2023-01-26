package chap06.check;

public class Q18Ex {
    public static void main(String[] args) {
        Q18 obj1 = Q18.getInstance();
        Q18 obj2 = Q18.getInstance();

        if(obj1 == obj2) {
            System.out.println("같은 객채");
        } else {
            System.out.println("다른 객체");
        }
    }
}
