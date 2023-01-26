package chap06.check;

public class Q15 {
    String id;
    String password;

    boolean login(String id, String password) {
        if (id == "hong" && password == "12345") {
            return  true; }
        else
            return false;
    }

    void logout(String id) {
        System.out.println("로그아웃");
    }

}
