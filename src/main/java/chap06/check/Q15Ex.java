package chap06.check;

public class Q15Ex {
    public static void main(String[] args) {
        Q15 q15 = new Q15();
        boolean result = q15.login("hong", "12345");

        if(result) {
            System.out.println("로그인");
            q15.logout("hong");
        } else {
            System.out.println("id 또는 pw가 올바르지 않음");
        }
    }
}
