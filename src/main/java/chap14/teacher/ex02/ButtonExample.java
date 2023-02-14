package chap14.teacher.ex02;

public class ButtonExample {
    public static void main(String[] args) {
        Button btnOk = new Button();
        btnOk.setClickListener(()-> {
            System.out.println("버튼을 눌렀습니다.");
        });
        btnOk.click();

        Button btnCancle = new Button();
        btnCancle.setClickListener(()-> {
            System.out.println("취소 버튼을 눌렀습니다.");
        });
        btnCancle.click();
    }
}
