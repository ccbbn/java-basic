package chap07.check;

import chap07.poly.ex2.Parent;

public class Q6c extends Q6p {
    private String name;

    public Q6c() {
        this("홍길"); // 자기자신의 생성자
        System.out.println("자식 콜");
    }

    public Q6c(String name) {
        this.name = name;
        System.out.println("자식이름 콜");

    }
}
