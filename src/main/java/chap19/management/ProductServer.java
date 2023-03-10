package chap19.management;

import chap19.B.SocketClient;
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

    ServerSocket serverSocket;
    ExecutorService threadPool;

    List<Product> products;


    public static Map<Integer, SocketClient> socketClientMap = Collections.synchronizedMap(new HashMap<>());


    public static class SocketClient{

        ProductServer productServer;
        Socket socket;
        DataInputStream dis;
        DataOutputStream dos;
        private int no;
        private String name;
        private int price;
        private int stock;



        public SocketClient(ProductServer productServer, Socket socket) {

            try {
                this.productServer = productServer;
                this.socket = socket;
                this.dis = new DataInputStream(socket.getInputStream());
                this.dos = new DataOutputStream(socket.getOutputStream());

                receive();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void receive(){
            productServer.threadPool.execute(() -> {

                try {
                    while (true) {

                        String receiveData = dis.readUTF();
                        JSONObject jsonObject =  new JSONObject(receiveData);
                        String menu = jsonObject.getString("menu");


                        switch (menu) {

                            case "1" :
                                this.no = jsonObject.getInt("no");
                                this.name = jsonObject.getString("name");
                                this.price = jsonObject.getInt("price");
                                this.stock = jsonObject.getInt("stock");
                                productServer.createServer(no, name, price, stock);

                                break;

                            case "2" :
                                this.no = jsonObject.getInt("no");
                                name = jsonObject.getString("name");
                                price = jsonObject.getInt("price");
                                stock = jsonObject.getInt("stock");

                                break;

                            case "3" :
                                this.no = jsonObject.getInt("no");
                                break;

                            case "4" :
                                break;

                            case "returnCreate" :
                                productServer.returnCreate(this);




                        }
                    }
                } catch (IOException e) {

                }
            });

        }
        public void send(String sendData) {

            try {

                dos.writeUTF(sendData);

                dos.flush();

            } catch (IOException e) {


            }

        }

    }


    public static void main(String[] args) {
        try {
            ProductServer productServer = new ProductServer();
            productServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void start() throws IOException {
        serverSocket = new ServerSocket(50001);  //???????????? ????????? ????????? , ????????? ??????
        products = new Vector<>(); // ????????? ????????? ?????????
        threadPool = Executors.newFixedThreadPool(100);
        System.out.println("[??????] ?????????");
        Thread thread = new Thread(() -> {
            try {
                while (true) { //?????? ????????? ?????? ????????????
                    int count = 1;
                    Socket socket = serverSocket.accept();  // ?????? ?????? ?????? ????????? ??????, ????????? ???????????? ??? ????????????
                    SocketClient socketClient = new SocketClient(this,socket);
                    socketClientMap.put(count++, socketClient);

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
    }

    int count = 0;
    public void createServer(int no, String name, int price, int stock) {
        Product product = new Product(no, name, price, stock);

        products.add(count++,product);

    }
    public void returnCreate(SocketClient socketClient) {
        JSONArray jsonObject = new JSONArray();
        jsonObject.put(0,products);
        String sendData = jsonObject.toString();

        Collection<SocketClient> socketClients = socketClientMap.values();
        for (SocketClient sc : socketClients) {
            sc.send(sendData);
        }

    }





}


