package chap04.while_statement;

public class continue_statement {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }


        for (int j = 1; j <= 10; j++) {
            while (j % 2 == 0) {
                System.out.println(j);
                break;

            }
        }


            int k = 1;
            while (k <= 10) {
                k++;
                if (k % 2 != 0) {
                    continue;
                }
                System.out.println(k);

            }
        }
    }



