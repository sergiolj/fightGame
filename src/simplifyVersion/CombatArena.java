package simplifyVersion;

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
        while (p1.getLife() > 0 && p2.getLife() > 0) {
            round();
            switchPlayers();
        }
        verifyWinner();
    }

    public void verifyWinner() {
        if (p1.getLife() <= 0) {
            System.out.println("\n"+p2.getPlayerName() + ", win!!");
        } else {
            System.out.println("\n"+p1.getPlayerName() + ", win!!");
        }
    }

    private void attack() {
        var damage = attackStrength - defenseStrength;
        if(engage) {
            System.out.println(attacker.getPlayerName() + " attack with strength " + attackStrength);
        }else {
            System.out.println(attacker.getPlayerName() + " choose not engage.");
        }

        if(defended){
                System.out.println(defender.getPlayerName() + " defend with strength " + defenseStrength);
            }else{
                System.out.println(defender.getPlayerName() + " was unable to block the attack");
            }
        if (damage > 0) {
            defender.setLife(defender.getLife() - damage);
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
        System.out.println("\nRound " + round + " Fight!!! - [" + p1.getLife() + "] x [" + p2.getLife() + "]");
        playerAttack();
        if(engage){
            playerDefend();
        }
        attack();
        }

    //Player One can attack or hesitate, if he attacks he trows the dices once again to determinate the strength of the
    //attack and then execute the attack.
    public boolean playerAttack() {
        switch (diceAction()) {
            case 1:
                attackStrength = diceActionStrength();
                return engage = true;
            case 2:
                attackStrength = 0;
                return engage = false;
            default:
                return false;
        }
    }

    //Player Two can defend or hesitate, if he defends he trows the dices once again to determinate the strength of the
    //defense to diminish the attack impact.
    public boolean playerDefend() {
        switch (diceAction()) {
            case 1:
                defenseStrength = diceActionStrength();
                return defended = true;
            case 2:
                defenseStrength = 0;
                return defended = false;
            default:
                return false;
        }
    }
}
