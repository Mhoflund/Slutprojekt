public class Monster extends Cards{
    // Attributes
    private int level;

    //Constructers
    public Monster(int level, String name){
        super(name, "monster");
        this.level= level;
    }
}
