package chap18.ex03;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadChar {
    public static void main(String[] args) {
        try {

            //1. 스트림 객체를 가져오면 된다
            //2. 객체 내 메소드(읽기/쓰기)를 통해 읽거나 쓰면 된다



            Reader reader =new FileReader("C:/Temp/test.txt");


        char[] data = new char[100];

        while (true) {
            int n = reader.read(data);  // data[]로 읽은게 저장됨
            if ( n == -1 ){         // 읽은 글자가 없다면(-1)
                break;
            }

            for ( int i = 0; i < n; i++){
                System.out.print(data[i]);
            }
        }



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
