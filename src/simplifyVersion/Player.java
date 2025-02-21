package simplifyVersion;

public class Player {
    private final String playerName;
    private int life = 10;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public int getLifeSize() {
        return life;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public String toString() {
        return getPlayerName();
    }
}
