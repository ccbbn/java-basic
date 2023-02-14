package chap14.teacher.ex05.exam02;

public class MethodReferenceExample {
	public static void main(String[] args) {
		Person person = new Person();
		person.ordering(String :: compareToIgnoreCase);
	}
}