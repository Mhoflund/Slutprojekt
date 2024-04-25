public class Cards {
    // attributes
    private static String name;
    private String type;

    // Constructer
    public Cards(String name, String type){
        this.name = name;
        this.type = type;
    }

    //Getters & setters
    public String getType() {
        return type;
    }

    public static String getName(){
        return name;
    }

}
