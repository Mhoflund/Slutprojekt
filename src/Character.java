import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Character {
    //Attributes
    private String name;
    private String gender;
    private boolean isMale;
    private int level;
    ArrayList<Cards> cards = new ArrayList<Cards>();
    ArrayList<Gear> gears = new ArrayList<Gear>();

    // constructor
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

    // A method for choosing the gender
    public void chooseGender(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your gender(F/M?: ");
        this.gender = scanner.nextLine();
        while(true){
            switch (gender) {
                case "F", "f" -> {
                    System.out.println("You picked Female");
                    isMale = false;
                }
                case "M", "m" -> {
                    System.out.println("You picked Male");
                    isMale = true;
                }
                default -> {
                    System.out.println("You are a loser, pick one of the options");
                }
            }
        }


    }

    // A method creating the cards for different type of gears
    public void createGears(){
        // Cards for armoury
        gears.add(new Armoury("Helmet", 1));
        gears.add(new Armoury("Pants", 3));
        gears.add(new Armoury("BulletproofVets", 4));

        // Cards for handgear
        gears.add(new HandGear(2, "Sword"));
        gears.add(new HandGear(3, "MagicSoft"));
        gears.add(new HandGear(1, "Knife"));
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
         cards.add(new Monster(3, "TheBitchyWitchAnton"));

        // Creating bonus cards
         cards.add(new Bonus("GenderSwitch"));
         cards.add(new Bonus("LevelUp"));
         cards.add(new Bonus("HandGear"));
         cards.add(new Bonus("Armoury"));

     }

     // Method that picks a random card
    public void pickCard(){
        Random random = new Random();
        // It takes a random card from 0 to the size of the card deck
        Cards pickedCard = cards.get(random.nextInt(0, cards.size()));
        System.out.println("your card is " + pickedCard);

        // Looking for witch type the card is
        switch (pickedCard.getType()){
            case "monster" -> fight(); // If it is a monster, it will run the method fight
            case "bonus" -> bonus(); // If it is a bonus, it will run the method bonus
        }
    }

    // Method for when a card is bonus, depending on which card it does different things
    public void bonus(){
        switch (Cards.getName()) {
            case "GenderSwitch" -> {
                isMale = !isMale;
                if(isMale){
                   gender = "Male";
                } else {
                    gender = "Female";
                }
                System.out.println("You are now " + gender);
            }
            case "LevelUp" -> level += 1;
            case "HandGear" -> {
                // Creating a new random
                Random random = new Random();
                // Choose a random gear
                Gear pickedHandgear = gears.get(random.nextInt(0, gears.size()));
                // A while loop checking that the picked gear is a Handgear
                // Continues until the picked gear is a handgear
                while(!pickedHandgear.getType().equals("Handgear")){
                    pickedHandgear = gears.get(random.nextInt(0, gears.size()));
                }
                System.out.println("Your picked Armoury: " + pickedHandgear);
            }
            case "Armoury" -> {
                Random random = new Random();
                // Choose a random gear
                Gear pickedArmoury = gears.get(random.nextInt(0, gears.size()));
                // A while loop checking that the picked gear is an Armoury
                // Continues until the picked gear is a Armoury
                while(!pickedArmoury.getType().equals("Armoury")){
                    pickedArmoury = gears.get(random.nextInt(0, gears.size()));
                }
                System.out.println("Your picked Armoury: " + pickedArmoury);

            }
        }
    }

    // A method for when the card is a monster
    public void fight(){
        System.out.println("Do you wanna use one of the bonus cards?");


    }









}
