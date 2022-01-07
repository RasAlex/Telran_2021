package telran.socket.server.controller;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;

public class ServerSocketAppl {
    public static void main(String[] args) {
        int port = 9000;
        try (ServerSocket serverSocket = new ServerSocket(port)){ // ожидание соединения с клиентами))
            while (true) {
                System.out.println("Awaiting incoming connections....");
                Socket clientSocket = serverSocket.accept(); //ссылка на сокет клиента (возвращает адрес и порт клиента)
                System.out.println("Connection established with " + clientSocket.getInetAddress() + ":" + clientSocket.getPort());
                try {
                    InputStream inputStream = clientSocket.getInputStream(); // привязываем стрим (обстракция JAVA) для получения данных от клиента
                    OutputStream outputStream = clientSocket.getOutputStream(); // привязываем стрим для отправки данных в сторону клиента
                    ObjectOutputStream oos = new ObjectOutputStream(outputStream); // делаем объект для отправки  стрима
                    ObjectInputStream ois = new ObjectInputStream(inputStream); // делаем объект для получения стрима
                    while (true) {
                        String message = ois.readObject().toString();
                        System.out.println("Server received: " + message);
                        oos.writeObject(message + " " + LocalTime.now());
                    }
                } catch (IOException e){
                    System.out.println("Client " + clientSocket.getInetAddress() + ":" + clientSocket.getPort() + " close connection");
                }
            }
            }
        catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
