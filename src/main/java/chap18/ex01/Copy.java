package chap18.ex01;

import java.io.*;

public class Copy {
    public static void main(String[] args) {

        try {
            InputStream is = new FileInputStream("C://Temp/apple.jpg");
            OutputStream os = new FileOutputStream("C://Temp/apple2.jpg");

            int num;
            while (true) {
                num = 0;
                num = is.read();
                if (num == -1) break;
                System.out.println(num);
                os.write(num);

            }

            os.flush();
            os.close();
            is.close();



        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
