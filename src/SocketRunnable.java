import java.net.Socket;
import java.io.DataInputStream;
import java.lang.Runnable;

public class SocketRunnable implements Runnable {
    Socket socket;

    public SocketRunnable(Socket socket) {
        this.socket = socket;
    }

    public run() {
        while (true) {
            DataInputStream stream = new DataInputStream(socket.getInputStream())

        }
    }
}
