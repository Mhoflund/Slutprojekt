
public class Gear {
    // Attributes
    private String type;
    private String name;
    private int defenseLevel;

    // Constructor
    public Gear(String name, String type){
        this.name = name;
        this.type = type;
    }

    // Getters & setters

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }
}
