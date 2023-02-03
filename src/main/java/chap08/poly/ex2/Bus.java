package chap08.poly.ex2;

public class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("버스런");
    }


    public void check(){
        System.out.println("요금확인");
    }
}

