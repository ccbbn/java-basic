package chap19.management;

import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ProductClient {

    Socket socket;
    static DataInputStream dis;
    static DataOutputStream dos;


    public static void main(String[] args) throws IOException {
        //192.168.0.10  // 192.168.200.106
        Socket socket = null;// 서버에 연결 요청

        ProductClient productClient = new ProductClient();
        productClient.connect();

        JSONObject jsonObject = new JSONObject();

        boolean run = true;
        while (run) {

            System.out.println("[상품 목록]");
            System.out.println("--------------------------------------------");
            System.out.println("no  name                price       stock   ");
            System.out.println("--------------------------------------------");
            receiveCreate();
            System.out.println("--------------------------------------------");
            System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
            System.out.println("선택: ");
            String input = new Scanner(System.in).next();

            if (input.equals("1")) {
                create(jsonObject);
            } else if (input.equals("2")) {
                update(jsonObject);
                //receive();
            } else if (input.equals("3")) {
                delete(jsonObject);
                //receive();
            } else if (input.equals("4")) {
                run = false;
            }
        }

    }

    private static void receiveCreate() {

        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String readData = dis.readUTF();
                    JSONArray json = new JSONArray(readData);
                    String clientIp = json.getString(0);

                    System.out.println(clientIp);
                }
            } catch (Exception e) {

            }
        });
        thread.start();




    }

    private void connect() throws IOException {
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
        System.out.println("[클라이언트] 서버에 연결됨");
    }


    private static void delete(JSONObject jsonObject) throws IOException {
        System.out.println("[상품 삭제]");
        jsonObject.put("menu","3");
        System.out.print("상품 번호: ");
        jsonObject.put("no",new Scanner(System.in).nextInt());
        String deleteData = jsonObject.toString();
        send(deleteData);


    }

    private static void update(JSONObject jsonObject) throws IOException {
        System.out.println("[상품 수정]");
        jsonObject.put("menu","2");
        System.out.print("상품 번호: ");
        jsonObject.put("no",new Scanner(System.in).nextInt());
        System.out.print("이름 변경: ");
        jsonObject.put("name",new Scanner(System.in).next());
        System.out.print("가격 변경: ");
        jsonObject.put("price", new Scanner(System.in).nextInt());
        System.out.print("재고 변경: ");
        jsonObject.put("stock", new Scanner(System.in).nextInt());
        String updateData = jsonObject.toString();
        send(updateData);


    }


    private static void create(JSONObject jsonObject) throws IOException {
        int no = 1;
        System.out.println("[상품 생성]");
        jsonObject.put("menu",1);
        jsonObject.put("no",no++);
        System.out.print("상품 이름: ");
        jsonObject.put("name", new Scanner(System.in).next());
        System.out.print("상품 가격: ");
        jsonObject.put("price", new Scanner(System.in).nextInt());
        System.out.print("상품 재고: ");
        jsonObject.put("stock", new Scanner(System.in).nextInt());
        String createData = jsonObject.toString();

        //dos.writeUTF(createData);
        send(createData);

    }

    private static void send(String sendData) throws IOException {
        dos.writeUTF(sendData);
        dos.flush();
    }

}

