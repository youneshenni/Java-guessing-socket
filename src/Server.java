import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {
    ServerSocket server;
    Game game;

    public Server(Game game) {
        this.game = game;
        ServerSocket server;
        try {
            server = new ServerSocket(8080);
            this.server = server;
            System.out.println("Listening for connections");
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Erreur lors de l'initialization du serveur");
            System.exit(-1);
        }
    }

    public void run() {
        super.run();
        while (true) {
            try {
                Socket s = server.accept();
                System.out.println("Socket connection");
                new Session(s, this.game).start();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(-1);
            }
        }

    }
}
