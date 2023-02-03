package chap09.ex05;

public class Button {
    //인터페이스타입 필드
    OnClickListener listener;  // 구현객체 필요

    //온클릭리스너 타입의 매개변수
    void setOnClickListener(OnClickListener listener) {
        this.listener = listener;

    }

    void touch() {
        listener.onClick(); // 구현 객체가 실행할 매서드

    }

    interface OnClickListener {
        void onClick();

    }


}
