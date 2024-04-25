import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Character {
    //Attributes
    private String name;
    private int level;
    private boolean genderSwitch = false;
    ArrayList<Cards> cards = new ArrayList<Cards>();
    ArrayList<Gear> gears = new ArrayList<Gear>();

    public Character(int level){
        this.level= level;
    }

    // Methods
    //A method to set a name
    public void chooseName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?: ");
        this.name = scanner.nextLine();
        System.out.println("Your name: " + name);
    }


    //A method creating a deck of cards
     public void createDeck(){
        // Creating monster Cards
        cards.add(new Monster(3, "AdamTheTroberg"));
        cards.add(new Monster(1, "TantonTcarlberg"));
        cards.add(new Monster(5, "TageTheTag"));
        cards.add(new Monster(2, "SuperMarrio"));
        cards.add(new Monster(7, "JonathanGräääääf"));
        cards.add(new Monster(1, "TheEvilAdam"));
        cards.add(new Monster(2, "TheGargasniperFilip"));
        cards.add(new Monster(1, "TheWooblyAnton"));
        cards.add(new Monster(1, "TheVeryScaryJonathan"));
        cards.add(new Monster(2, "TheVeryCrazyLazyAdam"));
        cards.add(new Monster(6, "TheVeryBouncyJumpingAdam"));

        // Creating bonus cards
         cards.add(new Bonus("GenderSwitch"));
         cards.add(new Bonus("LevelUp"));
         cards.add(new Bonus("HandGear"));
         cards.add(new Bonus("Armoury"));

     }

     // Method that picks a random card
    public void pickCard(){
        Random random = new Random();
        // It takes a random card from 0 til the size of the card deck
        Cards pickedCard = cards.get(random.nextInt(0, cards.size()));
        System.out.println("your card is " + pickedCard);

        // Looking for witch type the card is
        switch (pickedCard.getType()){
            case "monster" -> fight(); // If it is a monster, it will run the method fight
            case "bonus" -> bonus(); // If it is a bonus, it will run the method bonus
        }
    }

    public void bonus(){
        switch(Cards.getName()){
            case "GenderSwitch":
                boolean genderSwitch = true;
                break;
            case "LevelUp":
                level += 1;
                break;
            case "HandGear":
                break;
            case "Armoury":
                break;
        }
    }

    public void fight(){

    }









}
