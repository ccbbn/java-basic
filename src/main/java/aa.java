import java.util.stream.IntStream;
import java.util.stream.Stream;

public class aa {

    public static void main(String[] args) {

        int[][] x = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        solution(x);
    }

        private static int solution(int[][] dots) {
            int answer = 0;
            if (((dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]) == (dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0])) || ((dots[0][1] - dots[1][1]) / (dots[0][0] - dots[1][0]) == -1*(dots[2][1] - dots[3][1]) / (dots[2][0] - dots[3][0])) ||
                    ((dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]) == (dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0])) || ((dots[0][1] - dots[2][1]) / (dots[0][0] - dots[2][0]) == -1*(dots[1][1] - dots[3][1]) / (dots[1][0] - dots[3][0])) ||
                    ((dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]) == (dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0])) || ((dots[0][1] - dots[3][1]) / (dots[0][0] - dots[3][0]) == -1*(dots[1][1] - dots[2][1]) / (dots[1][0] - dots[2][0]))

            ) {
                answer = 1;
            }

            return answer;


//        public static String solution(String cipher, int code) {
//            String answer = "";
//            String[] a = cipher.split("");
//            for( int i = 0; i < (cipher.length()/code); i++){
//                answer += a[code*(i+1)-1];
//
//
//        }
//
//            return answer;
//
//    }
        }}
