package chap07.practice.TotalException;

public class RangeInvalidException extends Exception{
    public RangeInvalidException() {
    }

    public RangeInvalidException(String message) {
        super(message);
    }
}
