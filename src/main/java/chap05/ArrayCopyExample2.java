package chap05;

public class ArrayCopyExample2 {
    public static void main(String[] args) {
        String[] oldArr = {"1", "2", "3"};
        String[] newArr = new String[5];

        System.arraycopy(oldArr, 1, newArr, 0, oldArr.length-1);

        System.out.println(newArr[0]);
        System.out.println(newArr[1]);
        System.out.println(newArr[2]);
    }
}
