package algorithm.basic.Array;

public class PrimeNumber {
    public static void main(String[] args) {
        //소수: 자신과 1이 외의 어떤 정수로도나누어지지 않는 수
        // 소수 나열하기
        // 1 배열 없
        int c = 0;
        for (int n = 2; n <= 10; n++) {
            for (int i = 1; i <= n; i++) { // 3나누기 1, 3나누기2 3나누기 3,,,, 4나누기 1 4나누기 2나누기 3, 나누기 4

                if (n % i == 0) {
                    c++;
                }
            }
            if (c == 2) {
                System.out.println(n);
            }
            c = 0;
        }
    }
}



