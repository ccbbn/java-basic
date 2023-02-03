package chap09.ex05;

public class ButtonEx {
    public static void main(String[] args) {

        Button btn = new Button();

        btn.setOnClickListener(new CallListener());
        btn.touch();

        btn.setOnClickListener(new MessageListener());
        btn.touch();

    }
}
