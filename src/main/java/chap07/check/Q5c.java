package chap07.check;

public class Q5c extends Q5p {
    private int studentNo;

    public Q5c(String name, int studentNo) {
        super(name); // 부모 생성자 소환해야함
        // super()은 생략되어있지만 사용되고 있음, 자식에 name이 없어서 불러옴
        /// 상관없음
        this.name = name;
        this.studentNo = studentNo;

    }
}
