package chap18.inOut;

import javax.print.DocFlavor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadEx {
    public static <bytes> void main(String[] args) {

        InputStream is = null;
        try {
            is = new FileInputStream("C://Temp/test1.db");

//            byte[] bytes = is.readNBytes(10);
//            for(byte b : bytes){
//                System.out.println(b);
//            }

//            while (true) {
//                int data = is.read();
//                System.out.println(data);
//                if(data == -1){
//                    break;
//                }
//            }

            while (true) {
                int data = is.read();
                if(data == -1){
                    break;
                }
                System.out.println((char)data);
            }






        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
