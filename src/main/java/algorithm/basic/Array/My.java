package algorithm.basic.Array;

public class My {
    public static void main(String[] args) {
        int[] srcArr = {1, 2, 3, 4, 5};
        int[] copyArr = {0, 0, 0, 0, 0};

        // System.arraycopy(srcArr,1, copyArr, 2, 3);
        my(srcArr, 1, copyArr, 4, 1);


        for (int element : copyArr) {
            System.out.println(element);
        }
    }

    private static void my(int[] srcArr, int srcPos, int[] copyArr, int desPos, int length) {
        /*int[] temp = new int[length];
        for (int i = srcPos; i <= length; i++) {
            temp[i-srcPos] = srcArr[i];
        }
        for (int j = desPos; j <= length +1 ; j++) {
            copyArr[j] = temp[j-desPos];
        }*/
        for (int i = 0; i < length; i++) {
            copyArr[desPos + i] = srcArr[srcPos + i];
        }
    }
}
