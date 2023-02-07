package chap10.check.Q7;


public class NoExist extends Exception {
    public NoExist(){}
    public NoExist(String message){

        System.out.println("아이디가 존재하지 않습니다");
    }
}
