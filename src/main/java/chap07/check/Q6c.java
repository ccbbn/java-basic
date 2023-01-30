package chap07.check;

public class Q6c {
    private String name;

    public Q6c() {
        this("홍길");
        System.out.println("자식 콜");
    }

    public Q6c(String name) {
        this.name = name;
        System.out.println("자식이름 콜");

    }
}
