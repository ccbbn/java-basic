package chap06.check;

import jdk.swing.interop.DropTargetContextWrapper;

import java.sql.Struct;
import java.util.Scanner;

public class Q20Ex {
    private static Q20[] accountArray = new Q20[100];
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
//            } else if (selectNo == 4) {
//                withdraw();
//            } else if (selectNo == 5) {
                run = false;
            }
        }
        System.out.println("프로그램 종료");

    }

    //계좌생성하기
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
        Q20 row = new Q20(ano, owner, balance);

        for (int i = 0; i < accountArray.length; i++) {
            if (accountArray[i] == null) {
                accountArray[i] = row;
                break;
            }
        }
    }

    //계좌목록보기
    private static void accountList() {
        int i = 0;
        while (accountArray[i] != null) {
            System.out.println(accountArray[i].getAno() +
                    "     " + accountArray[i].getOwner() +
                    "      " + accountArray[i].getBalance());
            i++;
        }
    }

    // 예금하기
    private static void deposit() {
        System.out.print("계좌번호: ");
        String ano = scanner.next();
        System.out.print("예금액: ");
        int balance = scanner.nextInt();

        findAccount(ano);



    }

    // 출금하기
    private static void withdraw() {

    }

    //Account(Q20) 배열에서 ano와 동일한 Account 객체 찾기
    private static Q20 findAccount(String ano) {
        Q20 find = null;
        for (int i = 0; i < accountArray.length; i++) {
            if (ano == accountArray[i].getAno()) {
                find = accountArray[i];

            }
        }
        return find;
    }

}













