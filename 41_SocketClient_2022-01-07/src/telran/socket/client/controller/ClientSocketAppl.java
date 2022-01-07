package telran.socket.client.controller;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocketAppl {
    public static void main(String[] args) {
        String serverHost = "127.0.0.1";
        int port = 9000;
        try {
            Socket socket = new Socket(serverHost, port); // Создаём Соединение для подключения на хост и порт (выделяем ресурсы)
            InputStream inputStream = socket.getInputStream(); // привязываем стрим (обстракция JAVA) для получения данных
            OutputStream outputStream = socket.getOutputStream(); // привязываем стрим для отправки данных
            ObjectOutputStream oos = new ObjectOutputStream(outputStream); // делаем объект для отправки  стрима
            ObjectInputStream ois = new ObjectInputStream(inputStream); // делаем объект для получения стрима
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //считываем сообщение
            System.out.println("Enter message or type quit for exit");
            String message = br.readLine();
            while (!"exit".equalsIgnoreCase(message)){
                oos.writeObject(message);
                String response = ois.readObject().toString();
                System.out.println(response);
                message = br.readLine();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
