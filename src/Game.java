import java.lang.Math;

public class Game {
    int guess;
    boolean win = false;

    public Game() {
        this.guess = (int) (Math.random() * 999 + 1);
    }
}