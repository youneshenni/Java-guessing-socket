
public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        new Server(game).start();
    }
}
