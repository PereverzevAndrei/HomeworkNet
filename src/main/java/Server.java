import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(ServerConfig.PORT)) {
            out.println("Сервер запущен и ждет команды");
            while (true) {
                try (Socket client = server.accept();
                     PrintWriter writer = new PrintWriter(client.getOutputStream(), true);
                     BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
                    out.println("New connection accepted");
                    writer.println("Hello from server! Your port is  " + client.getPort());
                    System.out.println("Подключен клиент " + client.getPort());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
