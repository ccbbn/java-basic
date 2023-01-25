package chap06.OOP;

public class Tire {
    // 제조사, 크기, 공기압
    // 생성자를 만들어리
    // 가능한 모든 매개변수 조합으로 만들어라
    company company;
    int size;
    int pressure;

    public Tire() {}

    // 생성자 단축기 : alt + insert

    public Tire (company company, int size, int pressure) {
        this.company = company;
        this.size = size;
        this.pressure = pressure;
    }

    public Tire (int size, int pressure) {
        this.size = size;
        this.pressure = pressure;
    }

    public Tire (company company, int pressure) {
        this.company = company;
        this.pressure = pressure;
    }



}
