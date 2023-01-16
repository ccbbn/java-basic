package chap04.switch_statement;

public class switch_statement {
    public static void main(String[] args) {

        // switch : if-else와 친구
        int num = (int) (Math.random() * 6) + 1;
        char c = 'a';
        byte b = 1;
        long l = 1; //long은 못씀, 타입변환해야함
        short s = 1;
        String str = "hello"; // case 조건도 문자열도 바꿔야함

        // 정수타입, String
        switch (num) {
            case 1:
                System.out.println("1번");
                break;     //break 안걸면 계속실행함
            case 2:
                System.out.println("2번");
                break;
            case 3:
                System.out.println("3번");
                break;
            case 4:
                System.out.println("4번");
                break;
            case 5:
                System.out.println("5번");
                break;
            case 6:
                System.out.println("6번");
                break;

            default:
                System.out.println("디폴트");
                break;


        }

    }
}

