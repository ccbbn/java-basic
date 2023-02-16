package chap13generic.ex01;



// T: 타입 파리미터
public class Car<T> { // 정해지진 않은 타입, 사용할 때 변경

    T parts; // 타이어, 핸들, 사이드미러, 엔진

    T getParts(){
        return parts;
    }


    void setParts(T parts){
        this.parts = parts;
    }


}
