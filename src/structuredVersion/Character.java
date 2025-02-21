package structuredVersion;

public abstract class Character  implements CombatSystem{
    private final int life;
    private final int stamina;
    private final int heavyStrike;
    private final int lightStrike;

    public Character(int heavyStrike, int lightStrike) {
        this.heavyStrike = heavyStrike;
        this.lightStrike = lightStrike;
        this.life = 100;
        this.stamina = 10;
    }

    public void atack(){

    }

    public void defense(){

    }
    public void stamina(){

    }
}
