import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.IOException;

//import static sun.management.jmxremote.ConnectorBootstrap.PropertyNames.HOST;
//import static sun.management.jmxremote.ConnectorBootstrap.PropertyNames.PORT;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket(ServerConfig.HOST, ServerConfig.PORT);

             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println(reader.readLine());
            writer.println("Hello from client");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
