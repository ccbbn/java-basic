package chap07.ex2;

public class Student extends People {

    public Student(String name, String ssn) {
        // 부모의 생성자를 통해서 최기화
        super(name, ssn);

        // 또 다른 방법
        //super(); 앤 생략가능
       //this.name = name;
        //this.ssn = ssn;



    }
}
