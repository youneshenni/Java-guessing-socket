import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.lang.Thread;

public class Session extends Thread {
    Socket socket;
    Game game;

    public Session(Socket socket, Game game) {
        super();
        this.socket = socket;
        this.game = game;
    }

    public void run() {
        DataInputStream read;
        DataOutputStream write;
        try {
            read = new DataInputStream(this.socket.getInputStream());
            write = new DataOutputStream(this.socket.getOutputStream());
        } catch (IOException e) {
            System.err.println("Error reading received information");
            System.exit(-1);
            read = null;
            write = null;
        }
        while (true) {
            int guess;
            try {
                guess = read.readInt();
                System.out.println("Read value: " + guess);
            } catch (EOFException e) {
                guess = -1;
            } catch (IOException e) {
                guess = -1;
            }
            if (guess == -1)
                System.err.println("Error reading");
            else
                try {
                    write.writeInt(this.game.guess(guess));
                } catch (IOException e) {
                    System.err.println("Error sending result to client");
                }
            if (this.game.isWin())
                System.exit(0);

        }
    }
}
