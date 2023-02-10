package chap11.ex05;

public class ex05 {
    public static void main(String[] args) {
        StringBuilder sb =new StringBuilder().append("hello").append("!!!!").insert(5, " world");
        System.out.println(sb);
    }
}
