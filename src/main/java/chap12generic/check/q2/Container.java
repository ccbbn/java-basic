package chap12generic.check.q2;

public class Container<T> {
    T text;

    void set(T text) {this.text = text;}
    T get() {return text; }
}
