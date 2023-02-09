package chap11.ex02;

import chap06.OOP.ArgsConstructor;
import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Setter

public class Member {
    // 모든 자바 클래스는 Object클래스를 상속 받음
    //

    String name;
    int age;

    String nickName;







    public Member(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

//    @Override  //원래 기능을 오버라이드...무조건 트루가 나오게 변형시킴
//    public boolean equals(Object obj) {
//        return true;
//    }
//}

    @Override  //원래 기능을 오버라이드...기능을 바꿔버림
    public boolean equals(Object obj) {
        if (obj instanceof  Member) {
            Member member = (Member) obj;
            if(  (name.equals(member.name)) && (nickName.equals(member.nickName))) {
            return true;
            }
        } return false;
    }
    // 객체 해시코드 ( hashcode() : 메모리 번지를 이용해서 해시코드 생성)
    // 참조타입에서 == 는
    // a == b
    // 1. a.hashcode()와 b.hashcode()를 비교
    // 2. 1이 참일 때 equals()로 비교 -> a.equals(b)
    // 3. 2까지 같으면 동등객체


//    @Override //해시 코드를 변경해서 ==를 바꿔보자, 해쉬코드를 다 1로 바꿔버림, ==에서 해시코드 비교가 무의해짐
//    public int hashCode() {
//        return 1;
//    }


    @Override
    public int hashCode() {
        return this.age + this.name.hashCode() + this.nickName.hashCode();
    }

    @Override
    public String toString() {
        return this.name + " /" + this.nickName + " /" + this.age;
    }


}
