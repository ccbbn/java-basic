package chap10.check.Q7;

public class WrongPw extends Exception{
    public WrongPw(){}
    public WrongPw(String message){
        System.out.println("패스워드가 틀립니다");

    }
}
