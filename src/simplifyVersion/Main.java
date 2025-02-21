package simplifyVersion;

public class Main {
    public static void main(String[] args) {
        Player p1 = new Player("Ryu");
        Player p2 = new Player("Chun-Li");

        CombatArena arena = new CombatArena(p1,p2);
        arena.fight();
   }
}