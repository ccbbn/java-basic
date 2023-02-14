package chap14.teacher.ex03;

public class Impl implements Workable {
    @Override
    public void work(String name, String job) {
        System.out.println(name + "이" + job + "에서 열심히 일하고 있습니다.");
    }
}
