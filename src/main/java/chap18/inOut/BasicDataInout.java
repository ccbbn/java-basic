package chap18.inOut;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BasicDataInout {
    public static void main(String[] args) {


        OutputStream os;

        {
            try {
                os = new FileOutputStream("C:/temp/test1.db");

                byte[] bytes = {65,66,67,68,69,70};
                int i = 1;
                for (byte b : bytes) {
                    b = (byte) i++;

                }
                os.write(bytes);

                os.flush(); // 버퍼에 남은 것들을 지움
                os.close();


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
    // 출려(쓰기)
    // C:\test1.db와 연결된 출력 스트림




}

