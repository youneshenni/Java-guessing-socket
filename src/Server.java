import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    ServerSocket server;

    public Server() {
        ServerSocket server;
        try {
            server = new ServerSocket(8080);
            this.server = server;
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'initialization du serveur");
            System.exit(-1);
        }
    }

    public void listen() {
        while (true) {
            try {
                Socket s = server.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
