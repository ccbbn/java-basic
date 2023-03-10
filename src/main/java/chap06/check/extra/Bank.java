package chap06.check.extra;
import java.util.Scanner;

public class Bank {
    private static Map[] accountArray = new Map[100];  //필드라서 개체 안에 NULL로 참
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean run = true;
        while (run) {
            System.out.println("------------------------------------");
            System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("------------------------------------");
            System.out.print("선택> ");

            int selectNo = scanner.nextInt();

            if (selectNo == 1) {
                createAccount();
            } else if (selectNo == 2) {
                accountList();
            } else if (selectNo == 3) {
                deposit();
            } else if (selectNo == 4) {
                withdraw();
            } else if (selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");

    }

    //계좌생성하기

    static int i;

    private static void createAccount() {
        System.out.println("----------------");
        System.out.println("계좌생성");
        System.out.println("----------------");

        System.out.print("계좌번호: ");
        String ano = scanner.next();

        System.out.print("계좌주: ");
        String owner = scanner.next();

        System.out.print("초기입금액: ");
        int balance = scanner.nextInt();

        System.out.println("결과: 계좌가 생성되었습니다.");
        Map row = new Map(ano, owner, balance);

        accountArray[i] = row;
        i++;
    }

    //계좌목록보기
    private static void accountList() {
        System.out.println("----------------");
        System.out.println("계좌목록");
        System.out.println("----------------");

        for (int i = 0; i <= accountArray.length; i++) {
            if(accountArray[i] == null) { return; }
            System.out.print(accountArray[i].getAno());
            System.out.print("    ");
            System.out.print(accountArray[i].getOwner());
            System.out.print("    ");
            System.out.println(accountArray[i].getBalance());
        }



    }

    // 예금하기
    private static void deposit() {
        System.out.println("----------------");
        System.out.println("예금");
        System.out.println("----------------");
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("예금액: ");
        int save = scanner.nextInt();


        findAccount(ano).setBalance(findAccount(ano).getBalance() + save);

        System.out.println("결과: 예금이 성공되었다.");

    }

    // 출금하기
    private static void withdraw() {
        System.out.println("----------------");
        System.out.println("출금");
        System.out.println("----------------");
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("출금액: ");
        int minus = scanner.nextInt();

        findAccount(ano).setBalance(findAccount(ano).getBalance() - minus);

        System.out.println("결과: 출금이 성공되었다.");

    }

    //Account(Q20) 배열에서 ano와 동일한 Account 객체 찾기
    private static Map findAccount(String ano) {
        Map Account = null;
        for(int i = 0; i <= accountArray.length; i++) {
            if (accountArray[i].getAno().equals(ano)) {
                Account = accountArray[i];
                break;
            }
        }
        return Account;
    }

}

