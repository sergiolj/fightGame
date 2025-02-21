package simplifyVersion;

import java.lang.Character;

public class Player {
    private final String playerName;
    private int life;

    public Player(String playerName) {
        this.playerName = playerName;
        this.life = 10;
    }

    public int getLife() {
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
