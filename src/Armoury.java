public class Armoury extends Gear{
    // attributes
    private int defenceLevel;

    // Constructor
    public Armoury(String name, int defenceLevel){
        super(name, "Armoury");
        this.defenceLevel = defenceLevel;

    }

    // getters & setters


    public int getDefenceLevel() {
        return defenceLevel;
    }
}
