package chap01.exam02;

public class FloatDoubleExample {
    // float , double
    // float : 4바이트이지만 int와는 다름, 지수와 가수로 표현
    public static void main(String[] args) {
        double var1 = 3.14F; //자동 형변환
        float var2 = 3.14F; //f를 붙이면 float 리터럴로 인식


        //정밀도
        double var3 = 0.1234455643543543;
        float var4 = 0.1234455643543543F;

        System.out.println(var3);
        System.out.println(var4);

        int var5 = 3000000;
        //3000000 == 3e6
        double var6 = 3e6;

        System.out.println(var6);

        }
    }

