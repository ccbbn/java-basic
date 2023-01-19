package algorithm.basic.Array;

public class PrimeNumber2 {
    public static void main(String[] args) {
        // 검증 대상을 홀수로 한정

        int[] primes = new int[500];
        int primeIndex = 0;
        primes[primeIndex++] =2;


        for ( int n = 3; n <= 1000; n += 2) {
            int i;
            // primes[0] = 2, primes[1] = 3, prime[2] = 5
            // 나누는수를 n보다 작은 소수로 제한하자
            for (i = 0; i < primeIndex; i++) {
                if(n % primes[i] == 0) {
                    break;
                }
            }

            if (primeIndex == i) {
                primes[primeIndex++] = n;
            }
        }

    }

}




