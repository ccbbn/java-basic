package chap07.check;

public class Q6p {
    public String nation;

    public Q6p() {
        this("대한");

        System.out.println("부모콜");
    }

    public Q6p(String nation) {
        this.nation = nation;
        System.out.println("부모 국가");

    }
}
