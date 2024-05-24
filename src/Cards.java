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

    public String getName(){
        return name;
    }

    public int getLevel(){
        return 0;
    }



}
