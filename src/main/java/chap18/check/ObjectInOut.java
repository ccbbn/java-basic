package chap18.check;


import java.io.*;
import java.util.Arrays;

public class ObjectInOut {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 객체 10개 생성해서 파일에 저장하고 읽기
        // 읽은 정보 출력
        FileOutputStream fos = new FileOutputStream("C://Temp/ObjectTest.jpg");
        ObjectOutputStream oos = new ObjectOutputStream(fos);


        Product pr1 = new Product("빼빼로", 2000, 10);
        Product pr2 = new Product("치토스", 2000, 100);
        Product pr3 = new Product("소시지", 8000, 15);
        Product pr4 = new Product("가그린", 3000, 50);
        Product pr5 = new Product("물티슈", 1000, 5);
        Integer pr6 = new Integer(100000);
        Product pr7 = new Product("슬리퍼", 4000, 20);
        Product pr8 = new Product("종이컵", 900, 50);
        int[] productNumberArray = {(int)(Math.random()*10), (int)(Math.random()*10), (int)(Math.random()*10)};

        oos.writeObject(pr1);
        oos.writeObject(pr2);
        oos.writeObject(pr3);
        oos.writeObject(pr4);
        oos.writeObject(pr5);
        oos.writeObject(pr6);
        oos.writeObject(pr7);
        oos.writeObject(pr8);
        oos.writeObject(productNumberArray);

        oos.flush();
        oos.close();
        fos.close();

        FileInputStream fis = new FileInputStream("C://Temp/ObjectTest.jpg");
        ObjectInputStream ois = new ObjectInputStream(fis);

        Product objPr1 = (Product) ois.readObject();
        Product objPr2 = (Product) ois.readObject();
        Product objPr3 = (Product) ois.readObject();
        Product objPr4 = (Product) ois.readObject();
        Product objPr5 = (Product) ois.readObject();
        Integer objPr6 = (Integer) ois.readObject();
        Product objPr7 = (Product) ois.readObject();
        Product objPr8 = (Product) ois.readObject();
        int[] objPr9 = (int[]) ois.readObject();

        ois.close();
        fis.close();

        System.out.println(objPr1);
        System.out.println(objPr2);
        System.out.println(objPr6);
        System.out.println(Arrays.toString(objPr9));

    }
}
