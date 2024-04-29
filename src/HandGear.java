import java.lang.reflect.Type;

public class HandGear extends Gear{
    // attributes
    private int attackLevel;
    // constrcutors
    public HandGear(int attackLevel, String name){
        super(name, "Handgear");
        this.attackLevel = attackLevel;

    }

    // Getters & setters


    public int getAttackLevel() {
        return attackLevel;
    }
}
