package chap09.check.Q5;

public class AnonymousEx {
    public static void main(String[] args) {
        Anonymous anonymous = new chap09.check.Q5.Anonymous();

        anonymous.field.run();

        anonymous.method1();

        anonymous.method2(
                new Vehicle() {
                    @Override
                    public void run() {

                    }
                }
        );

    }
}
