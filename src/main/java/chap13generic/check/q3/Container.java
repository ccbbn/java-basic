package chap13generic.check.q3;

public class Container <T, S>{
    T key;
    S value;

    public T getKey() {
        return key;
    }

    public S getValue() {
        return value;
    }



    public void set(T key, S value) {
        this.key = key;
        this.value =value;
    }
}
