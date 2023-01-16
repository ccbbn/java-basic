package chap01.exam02;

public class ByteExample {
    public static void main(String[] args) {
        int var=1;
        //bit : 0 or 1
        //1byte : 8bits (1010 1010)
        //2^8 : 256
        //-128 ~ 127
       // byte var;
        var =0;
        //var = 128; // 128 정수형 리터럴
        var = 127;
        //그냥 전부 int쓰면 안됨?

        byte var1 = 125;
        int var2 = 125;
        //총 5회 반복함 0,1,2,3,4
        for(int i = 0; i< 5; i++){
            var1++; //126
            var2++; //126
            System.out.println("var1: "+var1);
            System.out.println("var2: "+var2);
        }
    }
}
