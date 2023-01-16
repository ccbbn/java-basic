package chap01.quiz;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Quiz01 {
    public static void main(String[] args)  throws FileNotFoundException {

        ///인트로 읽을 수 있는 애들만 읽기
        File file = new File("quiz1.txt");
        Scanner scanner = new Scanner(file);

        while( scanner.hasNext()){
            long x = scanner.nextLong();  // 변수를 지정해서 해야함, 지정하지 않고 그냥쓰면 계속 다음 것을 읽음//

            if ((x <= Integer.MAX_VALUE) && (x >= Integer.MIN_VALUE))
            {System.out.println(x);}




        }

    }
}
