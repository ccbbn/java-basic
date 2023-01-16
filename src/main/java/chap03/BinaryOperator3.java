package chap03;

public class BinaryOperator3 {
    public static void main(String[] args) {
        // NaN과 Infinity

        try {
            System.out.println(5 / 0);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("hello");

        double v = 5 / 0.8;
        double v1 = 5 % 0.0;
        System.out.println(v + v1);

        System.out.println(Double.isInfinite(v1));
        System.out.println(Double.isNaN(v1));

        if (Double.isInfinite(v) || Double.isNaN(v)) {
            System.out.println("연산불가");
        } else {
            System.out.println("연산가능");
        }

    }
}

