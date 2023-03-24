import java.util.Arrays;

public class aa {

    public static void main(String[] args) {

//        int[][] x = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
//        String[] spell = {"p", "o", "s"};
//        String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
////        solution("1 2 Z 3"); // (3,-,4,+,5)
//        int[][] score = {{80, 70}, {90, 50}, {40, 70}, {50, 80}};


        solution(new int[]{10000,20,36,47,40,6,10,7000}, 30);


    }

    public static void solution(int[] numList, int n) {

        int[] abs1 = new int[numList.length];
        int[] place = new int[2];
        int[] answer = new int[numList.length];


        for ( int i = 0; i < numList.length; i++ ) {
                abs1[i] = Math.abs(numList[i] - n);
        }
        Arrays.sort(abs1); /*10 10 20 30 40*/
        int same;
        int order=0;
        for (int k = 1; k < numList.length; k++) {
            if (abs1[k - 1] == abs1[k]) {
                same = abs1[k - 1];
                for (int j : numList) {
                    if (same == Math.abs(j - n)) {
                        place[order++] = j;
                    }
                }
            }
        }
        for (int i = 0 ; i < numList.length; i++) {

        }




        System.out.println(Arrays.toString(abs1));
    }
}



















