package chap18.ex03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class WriterChar {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("C:/Temp/test.txt",true);

//            writer.write('a');
//            writer.write('b');
//            writer.write('c');
//
//            writer.append("Hello",1,3);
//            writer.flush();
//            writer.close(); // os 시스템상 문서 작성을 완료함
//
            // 콘솔창에서 사용자 입력을 받아서 txt 파일에 저장
//
//            for (int i = 0; i < 5 ; i++){
//            Scanner scanner = new Scanner(System.in);
//                String input = scanner.next();
//            writer.write(input);
//            writer.append("\n");
//            }
            Scanner nScanner = new Scanner(System.in);
            boolean rep = true;
            while (rep) {
                String input1 = nScanner.next();

                if (!input1.equals("q!")) {
                    writer.write(input1 + "\n");
                    //writer.flush(); 바로 갱신해줌

                } else {
                    rep = false;
                }
            }
            writer.flush();
            writer.close();

//
//            while (true) {
//                Scanner nScanner = new Scanner(System.in);
//                String input1 = nScanner.next();
//
//                if (input1.equals("q!")) {
//                    break;
//                }
//            writer.write(input1 + "\n");
//            }
//            writer.flush();
//            writer.close();

//            }
//            writer.flush();
//            writer.close();








        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
