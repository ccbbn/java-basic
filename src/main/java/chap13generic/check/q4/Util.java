package chap13generic.check.q4;

public class Util {
     public static <A extends Number > int getValue(A a1, A a2){


         double v1 = a1.doubleValue();
         double v2 = a2.doubleValue();

        return Double.compare(v1, v2);
    }


}
