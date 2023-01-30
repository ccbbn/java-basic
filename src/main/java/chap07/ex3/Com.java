package chap07.ex3;

public class Com extends Cal{

    @Override //가독성, 부모 것 대신 자식의 방식으로 재정의
    double areaCircle(double r) {
        return 3.14 * r * r;
    }
}
