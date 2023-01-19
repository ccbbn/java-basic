public class Memo {
    public static void main(String[] args) {
        for (int n = 2; n <= 4; n++) {
            for (int i = 1; i <= n; i++) { // 3나누기 1, 3나누기2 3나누기 3,,,, 4나누기 1 4나누기 2나누기 3, 나누기 4

                int c = 0;
                int s = 0;
                if (n % i == 0) {
                    c++;

                    s = c + s;
                }


                System.out.println(s);

                }
            }

        }

    }

