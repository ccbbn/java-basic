package chap14.teacher.verify;

import java.util.function.IntBinaryOperator;

public class Impl implements IntBinaryOperator {
    @Override
    public int applyAsInt(int left, int right) {
        if(left >= right) return left;
        else return right;
    }
}
