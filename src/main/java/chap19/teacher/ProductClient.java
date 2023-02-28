package chap19.teacher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Optional;
import java.util.Scanner;

public class ProductClient {
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    public static void main(String[] args) {
        try {
            ProductClient client = new ProductClient();
            client.connect();
            //while (true) {
            client.showlist();
            //  }
        } catch (IOException e) {

        }

    }

    private void showlist() throws IOException {

        System.out.println("[상품 목록]");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-6s%-30s%-15s%-10s\n", "no", "name", "price", "stock");
        System.out.println("---------------------------------------------------------------");

        // 서버 : 클라이언트가 요청할 때만 응답을 한다.

        // 목록 조회 : 클라이언트 -> 서버로 요청
        JSONObject request = new JSONObject(); // { }
        request.put("menu", 0);
        dos.writeUTF(request.toString());
        dos.flush();

        // 보내준 상품 목록 수신  /// 기본 베이스
        String response = dis.readUTF();
        JSONObject jsonObject = new JSONObject(response);
        String result = jsonObject.getString("result");
        JSONArray data = jsonObject.getJSONArray("data");
        // 제이슨1(제이슨어레이(제이슨,제이슨,제이슨)))을 역으로 다시 품
        // 제이슨1 -> 제이슨어레이 -> 제이슨2

        if(jsonObject.getString("result").equals("success")) {
            for (int i = 0; i < data.length(); i++) {
                System.out.printf("%-6s%-30s%-15s%-10s\n",
                        data.getJSONObject(i).getInt("no"),
                        data.getJSONObject(i).getString("name"),
                        data.getJSONObject(i).getInt("price"),
                        data.getJSONObject(i).getInt("stock"));



            }
        }


        boolean run = true;
        while (run) {

            System.out.println("--------------------------------------------");
            System.out.println("메뉴: 1.Create | 2.Update | 3.Delete | 4.Exit");
            System.out.println("선택: ");
            String input = new Scanner(System.in).next();
            if (input.equals("0")) {
                 all();
            } else if (input.equals("1")) {
                createProduct();
                showlist();
            } else if (input.equals("2")) {
                updateProduct();
                showlist();
            } else if (input.equals("3")) {
                deleteProduct();
                showlist();
            } else if (input.equals("4")) {
                //run = false;
            }

        }

        }

    private void all() {
    }


    private void connect() throws IOException {
        socket = new Socket("localhost", 50001);
        dis = new DataInputStream(socket.getInputStream());
        dos = new DataOutputStream(socket.getOutputStream());
    }

    private void createProduct() throws IOException {
        JSONObject jsonObject = new JSONObject();
        int no = 3;
        ++no;
        System.out.println("[상품 생성]");
        jsonObject.put("menu",1);
        jsonObject.put("no",no);
        System.out.print("상품 이름: ");
        jsonObject.put("name", new Scanner(System.in).next());
        System.out.print("상품 가격: ");
        jsonObject.put("price", new Scanner(System.in).nextInt());
        System.out.print("상품 재고: ");
        jsonObject.put("stock", new Scanner(System.in).nextInt());
        String createData = jsonObject.toString();
        dos.writeUTF(createData);
        dos.flush();



    }
    private void updateProduct() throws IOException {
        JSONObject jsonObject = new JSONObject();
        System.out.println("[상품 수정]");
        jsonObject.put("menu",2);
        System.out.print("상품 번호: ");
        jsonObject.put("no",new Scanner(System.in).nextInt());
        System.out.print("이름 변경: ");
        jsonObject.put("name",new Scanner(System.in).next());
        System.out.print("가격 변경: ");
        jsonObject.put("price", new Scanner(System.in).nextInt());
        System.out.print("재고 변경: ");
        jsonObject.put("stock", new Scanner(System.in).nextInt());
        String updateData = jsonObject.toString();
        dos.writeUTF(updateData);
        dos.flush();

    }



    private void deleteProduct() throws IOException {
        JSONObject jsonObject = new JSONObject();
        System.out.println("[상품 삭제]");
        jsonObject.put("menu", 3);
        System.out.print("상품 번호: ");
        jsonObject.put("no",new Scanner(System.in).nextInt());
        String deleteData = jsonObject.toString();
        dos.writeUTF(deleteData);
        dos.flush();


    }




}
