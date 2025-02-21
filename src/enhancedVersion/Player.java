package enhancedVersion;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Player {
    private final String playerName;
    private int life = 10;
    List<Character> lifeBarr = new Stack<>();

    public Player(String playerName) {
        this.playerName = playerName;
        this.lifeBarr = createLifeBarr();
    }

    public List<Character> createLifeBarr() {
        for (int i = 0; i < this.life; i++) {
            lifeBarr.add('█');
        }
        return lifeBarr;
    }

    public List<Character> getLifeBarr() {
        return lifeBarr;
    }
    public void decreaseLifeBarr(int quantity) {
        if(quantity>=lifeBarr.size()) {
            quantity = lifeBarr.size();
        }
        for(int i=0; i<quantity; i++) {
            lifeBarr.removeFirst();
        }
    }

    public String lifeBarToString() {
        if (lifeBarr.isEmpty()) { // if lifeBarr is Empty represent as []
            return "[-]";
        }
        return "[" + lifeBarr.stream() //Create a stream of elements from lifeBarr
                .map(String::valueOf)
                .collect(Collectors.joining("")) + "]";
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
