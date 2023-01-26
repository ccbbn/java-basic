package chap06.check;

public class Q18 {
    private static Q18 q18 = new Q18();

    private Q18(){}

    static Q18 getInstance(){
        return q18;
    }
}
