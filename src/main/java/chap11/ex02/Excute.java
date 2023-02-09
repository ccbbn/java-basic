package chap11.ex02;

import chap08.Check.Q3.Soundable;

import java.util.HashSet;

public class Excute {
    public static void main(String[] args) {


      Member member1 = new Member("Kim", "nick");
      Member member2 = new Member("Kim","nick");
//        System.out.println(member.hashCode());
//        //멤버 클래스에 아무것도 없어도 Object 클래스를 상속, 최상위 부모라
//
//        System.out.println((member.equals(new Member())));

        System.out.println(member1.equals(member2));
        System.out.println(member1 == member2);

        if(member1.hashCode() == member2.hashCode()) {
            if(member1.equals(member2)){
                System.out.println("동등하다");
            }
        }

        // HashSet, HashMap <- 여기에 데이터를 넣을 때
        // hashcode()와 equals()의 결과를 보고 동등비교
        // 해시코드가 첨에 다르면 다른객체,
        // 해시코드가 같고 equals()까지 같으면같은 객체


        Member[] members = new Member[100]; //<- 우리가 하던 방식
        HashSet hashSet = new HashSet();

        members[0] = member1;
        members[1] = member2;

        hashSet.add(member1);  //중복체크를 함
        hashSet.add(member2);
        System.out.println(hashSet.size());
        for (Object member : hashSet){
            System.out.println((Member)member);
        }

        member1.age = 5;
        member2.age = 6;


        //toString()은 원래 문자정보를 리턴함
        System.out.println(member1.toString());
        System.out.println(member2.toString());

    }
}
