package chap05;

public class ArrayCopyExample {
    public static void main(String[] args) {
        int[] oldArr = {1, 2, 3};
        int[] newArr =oldArr;  // <- 참조값을 복사
        int[] newArrByFor = new int[3];


        for (int i = 0; i < oldArr.length; i++) {
            newArrByFor[i]  = oldArr[i];  // <- 실제 배열요소의 값을 복사
        }

        oldArr[0] = 100;
        oldArr[1] = 100;
        oldArr[2] = 100;



        System.out.println(newArr[0]);
        System.out.println(newArr[1]);
        System.out.println(newArr[2]);

        System.out.println(newArrByFor[0]);
        System.out.println(newArrByFor[1]);
        System.out.println(newArrByFor[2]);


    }
}
