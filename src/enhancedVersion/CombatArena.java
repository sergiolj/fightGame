package enhancedVersion;

import java.util.Random;

public class CombatArena {
    Random rand = new Random();

    private final Player p1;
    private final Player p2;
    private Player attacker;
    private Player defender;
    private boolean engage = false;
    private boolean defended = false;

    private int attackStrength;
    private int defenseStrength;
    private int round = 0;

    public CombatArena(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.attacker = p1;
        this.defender = p2;
    }

    public void fight() {
        System.out.println("Today's Fight [" + p1.getPlayerName() + "] x [" + p2.getPlayerName() + "]");
        while (p1.getLifeSize() > 0 && p2.getLifeSize() > 0) {
            round();
            switchPlayers();
        }
        verifyWinner();
    }

    public void verifyWinner() {
        Player winner = (p1.getLifeSize()<=0) ? p2 : p1;
        System.out.println("\n"+ winner.toString().toUpperCase() + ", wins!!");
    }

    private void attack() {
        var damage = attackStrength - defenseStrength;
        if(engage && defended) {
            System.out.println(attacker.getPlayerName() + " attacks with a strength of " + attackStrength);
            System.out.println(defender.getPlayerName() + " defends with a strength of " + defenseStrength);
        }else if (!engage) {
            System.out.println(attacker.getPlayerName() + " chose not to engage.");
        }

        if(engage && !defended){
            System.out.println(attacker.getPlayerName() + " attacks with a strength of " + attackStrength);
            System.out.println(defender.getPlayerName() + " fail to block the attack");
        }
        if (damage > 0) {
            defender.setLife(defender.getLifeSize() - damage);
            defender.decreaseLifeBarr(damage);
        }
    }

    public int diceAction() {
        return rand.nextInt(1, 3);
    }

    public int diceActionStrength() {
        return rand.nextInt(1, 7) + rand.nextInt(1, 7);
    }

    public void switchPlayers() {
        if (attacker.equals(p1)) {
            attacker = p2;
            defender = p1;
        } else {
            attacker = p1;
            defender = p2;
        }
    }

    public void round() {
        round++;
        System.out.println("\nRound " + round + " Fight!!!" );
        System.out.println("["
                + p1.getPlayerName().toUpperCase() + "] " + p1.lifeBarToString() + " x ["
                + p2.getPlayerName().toUpperCase() + "] " + p2.lifeBarToString() + "");
        playerAttack();
        if(engage){
            playerDefend();
        }
        attack();
        }

    public void playerAttack() {
        switch (diceAction()) {
            case 1:
                attackStrength = diceActionStrength();
                engage = true;
                break;
            case 2:
                attackStrength = 0;
                engage = false;
                break;
        }
    }

    public void playerDefend() {
        switch (diceAction()) {
            case 1:
                defenseStrength = diceActionStrength();
                defended = true;
                break;
            case 2:
                defenseStrength = 0;
                defended = false;
                break;
        }
    }
}
