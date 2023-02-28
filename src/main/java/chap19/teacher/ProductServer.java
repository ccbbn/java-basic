package chap19.teacher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductServer {
    // 서버
    Set<SocketClient> socketClients;
    ServerSocket serverSocket;
    List<Product> products;
    ExecutorService threadPool;





    public static void main(String[] args) {
        try {
            ProductServer server = new ProductServer();
            server.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 서버 기능
        // 클라이언트 요청 수락
        // 데이터 송수신용 소켓 -> SocketClient로 래핑 후 "저장"
            // 요청 JSON을 해석하고 처리
            // 생성 요청 -> "생성"
            // 수정 요청 -> "수정"
            // 삭제 요청 -> "삭제"
        // 처리 결과를 JSON으로 만들어 응답




    }



    private void start() throws IOException {
        initialize();
        System.out.println("[서버] 시작됨");
        listenConnectRequest();
    }

    private void initialize() throws IOException {
        serverSocket = new ServerSocket(50001);
        products = new Vector<Product>();
        threadPool = Executors.newFixedThreadPool(50);
        socketClients = new HashSet<>();
    }

    private void listenConnectRequest() throws IOException {
        while (true) {
            Socket socket = serverSocket.accept();
            SocketClient socketClient = new SocketClient(socket,
                    new DataInputStream(socket.getInputStream()),
                    new DataOutputStream(socket.getOutputStream()));
            socketClients.add(socketClient);

            socketClient.start();
            // socket을 매개변수로 해서 SocketClient 생성 후 자료구조에 담기
            // 클라이언트 10개 연결 -> Socketclient 10개 생성
        }
    }


    public class SocketClient {
        private Socket socket;
        DataInputStream dis;
        DataOutputStream dos;



        int no;
        String name;
        int price;
        int stock;


        public SocketClient(Socket socket, DataInputStream dis, DataOutputStream dos) {
            this.socket = socket;
            this.dis = dis;
            this.dos = dos;
        }

        public void start() {
            threadPool.execute(() -> {
                while (true) {
                    try {
                        String readData = dis.readUTF();
                        // { "menu", 0 }
                        JSONObject request = new JSONObject(readData);
                        int menu = request.getInt("menu");

                        switch (menu) {
                            case 0:
                                respondList();
                                break;

                            case 1 :
                                createProduct(request.getInt("no"), request.getString("name"), request.getInt("price"), request.getInt("stock"));
                                break;

                            case 2:
                                updateProduct(request.getInt("no"), request.getString("name"), request.getInt("price"), request.getInt("stock"));
                                break;

                            case 3:
                                deleteProduct(request.getInt("no"));
                                break;



                        }


                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            });
        }



        private void respondList() throws IOException {
            // 상품 조회해서 클라이언트한테 응답
            // 테스트용 가데이터 만들기
            products.add(new Product(1, "삼다수", 500, 10));
            products.add(new Product(2, "백산수", 500, 10));
            products.add(new Product(3, "에비앙", 500, 10));

            JSONArray data = new JSONArray(); // JSONObject
            for (Product p : products) {
                JSONObject product = new JSONObject();
                product.put("no", p.getNo());
                product.put("name", p.getName());
                product.put("price", p.getPrice());
                product.put("stock", p.getStock());
                data.put(product);
            }  // 제이슨 어레이배열(data)에 제이슨을 하나씩 집어 넣어줌
                //


            JSONObject response = new JSONObject();
            response.put("result", "success");
            response.put("data", data);
            //제이슨(제이슨어레이(제이슨)))   response(data(product들))

            dos.writeUTF(response.toString());
            dos.flush();
        }


        private void createProduct(int no, String name, int price, int stock) throws IOException {
            products.add(new Product(no, name, price, stock));

            JSONArray data = new JSONArray(); // JSONObject

            for (Product p : products) {
                JSONObject product = new JSONObject();
                product.put("no", p.getNo());
                product.put("name", p.getName());
                product.put("price", p.getPrice());
                product.put("stock", p.getStock());
                data.put(product);
            }
//            for (int i = 0; i < products.size(); i++) {
//                JSONObject product = new JSONObject();
//                product.put("no", products.get(i).getNo());
//                product.put("name", products.get(i).getName());
//                product.put("price", products.get(i).getPrice());
//                product.put("stock", products.get(i).getStock());
//                data.put(product);
//            }

            JSONObject response = new JSONObject();
            response.put("result", "success");
            response.put("data", data);
            //제이슨(제이슨어레이(제이슨)))   response(data(product들))

            dos.writeUTF(response.toString());
            dos.flush();

        }


        private void updateProduct(int no, String name, int price, int stock) throws IOException {

            JSONArray jsonArray = new JSONArray();
            for ( int i = 0; i < products.size(); i++) {
                JSONObject product = new JSONObject();
                if ( products.get(i).getNo() == no) {
                    products.get(i).setName(name);
                    products.get(i).setPrice(price);
                    products.get(i).setStock(stock);
                    product.put("no",products.get(i).getNo());
                    product.put("name", products.get(i).getName());
                    product.put("price", products.get(i).getPrice());
                    product.put("stock", products.get(i).getStock());
                    jsonArray.put(product);
                } else if ( products.get(i).getNo() != no) {
                    product.put("no",products.get(i).getNo());
                    product.put("name", products.get(i).getName());
                    product.put("price", products.get(i).getPrice());
                    product.put("stock", products.get(i).getStock());
                    jsonArray.put(product);
                }
            }

            JSONObject response = new JSONObject();
            response.put("result", "success");
            response.put("data", jsonArray);
            dos.writeUTF(response.toString());
            dos.flush();

        }


        private void deleteProduct(int no) throws IOException {
            JSONArray jsonArray = new JSONArray();
            for ( int i = 0; i < products.size(); i++) {
                JSONObject product = new JSONObject();
                if ( products.get(i).getNo() == no) {
                    products.remove(i);
                } else if ( products.get(i).getNo() != no) {
                    product.put("no",products.get(i).getNo());
                    product.put("name", products.get(i).getName());
                    product.put("price", products.get(i).getPrice());
                    product.put("stock", products.get(i).getStock());
                    jsonArray.put(product);
                }
            }

            JSONObject response = new JSONObject();
            response.put("result", "success");
            response.put("data", jsonArray);
            dos.writeUTF(response.toString());
            dos.flush();


        }

        // 생성자
        // 메소드
            // 생성
            // 수정
            // 삭제

    }
}
