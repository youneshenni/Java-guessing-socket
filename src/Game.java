import java.lang.Math;

public class Game {
    private int secret;
    private boolean win = false;

    public Game() {
        this.secret = (int) (Math.random() * 999 + 1);
    }

    public int guess(int attempt) {
        if (attempt < this.secret) {
            return -1;
        }
        if (attempt > this.secret)
            return 1;
        this.win = true;
        return 0;
    }

    public boolean isWin() {
        return this.win;
    }
}