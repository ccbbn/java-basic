package chap06.anno;
import java.lang.reflect.Method;

public class AnnoEx {
    public static void main(String[] args) {
        // 1. 컴파일러에게 코드 문법을 체크하도록 정보를 제공
        // 2. 코드 자동 생성을 할 수 있도록 정보제공
        // 3. 실행 시 특정 기능을 실행할 수 있도록 정보제공
        Method[] declaredMethods = Service.class.getDeclaredMethods(); // 리플렉션

        for (Method method : declaredMethods) {
            System.out.println("method");
        }

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Anno.class)) {
                // 메소드에 어노텐션이 붙어있냐
            }
        }

        for (Method method : declaredMethods) {
            if (method.isAnnotationPresent(Anno.class)) {
                Anno anno = method.getAnnotation(Anno.class);

                System.out.println(method.getName());
                for (int i = 0; i < anno.number(); i++) {
                    System.out.println(anno.value());
                }
                System.out.println();
            }

        }
    }
}

