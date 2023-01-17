package chap05;

public class StringExamlple {
    public static void main(String[] args) {
        // 데이터 타입: 원시 타입 vs 참조 타입
        // 둘을 나누는 이유?: 저장되는 값이 다르다
            // 원시 타입: 데이터의 실제값을 저장
            // 참조 타입: 데이터의 참조값을 저장
        // 메모리 구조와 관련
            // HW <-> OS <-> JVM <-> 프로그램 실행
            // 메소드 영역, 스택 영역, 힙 영역
            // 구분을 짓는 이유? 효율적인 메모리 사용위해
        // 메소드 영역
            // 모두(스레드)가 공유하는 영역이다 == 언제 어디서나 접근가능
        // 힙 영역
            // 객체와 배열이 생성되는 영역
        // 스택 영역
            // 메소드: 프레임
            // 범위를 벗어나면 사용불가
    }

}

