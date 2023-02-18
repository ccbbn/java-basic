package chap07.practice.ArrayList_refactoring;

public class RangeInvalidException extends Exception{
    public RangeInvalidException() {
    }

    public RangeInvalidException(String message) {
        super(message);
    }
}
