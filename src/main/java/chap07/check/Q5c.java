package chap07.check;

public class Q5c extends Q5p {
    private int studentNo;

    public Q5c(String name, int studentNo) {
        super(name); // 부모 생성자 소환해야함


        this.name = name;
        this.studentNo = studentNo;

    }
}
