package chap06.check;

public class Q19Ex {
    public static void main(String[] args) {
        Q19 account = new Q19();

        account.setBalance(1000);
        System.out.println("현재잔고: " + account.getBalance());

        account.setBalance(-100);
        System.out.println("현재잔고: " + account.getBalance());

        account.setBalance(2000000000);
        System.out.println("현재잔고: " + account.getBalance());

        account.setBalance(300000);
        System.out.println("현재잔고 " + account.getBalance());

    }

}
