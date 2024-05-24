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
    ArrayList<Gear> armouries = new ArrayList<>();
    ArrayList<Gear> handGears = new ArrayList<>();

    // constructor
    public Character(int level){
        this.level = level;
        chooseName();
        chooseGender();
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
        System.out.println("What is your gender(F/M?): ");
        this.gender = scanner.nextLine();
        boolean falseInput = true;
        // A switch making sure the user is putting the right value
        while(falseInput){
            switch (gender) {
                // If the user picks female
                case "F", "f" -> {
                    System.out.println("You picked Female");
                    isMale = false;
                    falseInput = false;
                } // If the user picks male
                case "M", "m" -> {
                    System.out.println("You picked Male");
                    isMale = true;
                    falseInput = false;
                } // If the user does not pick one of the options
                default -> {
                    System.out.println("Pick one of the options");
                    this.gender = scanner.nextLine();
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
        Cards pickedCard = cards.get(random.nextInt(1, cards.size()));
        System.out.println("your card is " + pickedCard.getType());

        // Looking for witch type the card is
        switch (pickedCard.getType()){
            case "bonus" -> bonus(pickedCard); // If it is a bonus, it will run the method bonus
            case "monster" -> fight(pickedCard); // If it is a monster, it will run the method fight
        }
    }

    // Method for when a card is bonus, depending on which card it does different things
    public void bonus(Cards pickedCard){
        switch (pickedCard.getName()) {
            // If the card is genderswitch
            case "GenderSwitch" -> {
                isMale = !isMale;
                if(isMale){
                   gender = "Male";
                } else {
                    gender = "Female";
                }
                System.out.println("You are now " + gender);
            }
            case "LevelUp" -> level += 1; // if the card is level upp
            case "HandGear" -> handGear(pickedCard); // Runs a method for handgear

            case "Armoury" -> armoury(pickedCard); // Runs a method for armoury
        }
    }

    //A method that picks a random handgear
    public void handGear(Cards card){
        // Creating a new random
        Random random = new Random();
        // Choose a random gear
        Gear pickedHandgear = gears.get(random.nextInt(0, gears.size()));
        // A while loop checking that the picked gear is a Handgear
        // Continues until the picked gear is a handgear
        while(!pickedHandgear.getType().equals("Handgear")){
            pickedHandgear = gears.get(random.nextInt(0, gears.size()));
            level += gears.size();
        }
        handGears.add(pickedHandgear);
        System.out.println("Your picked Hand Gear: " + pickedHandgear);
    }

    // A method that picks a random armoury
    public void armoury(Cards card){
        Random random = new Random();
        // Choose a random gear
        Gear pickedArmoury = gears.get(random.nextInt(0, gears.size()));
        // A while loop checking that the picked gear is an Armoury
        // Continues until the picked gear is an Armoury
        while(!pickedArmoury.getType().equals("Armoury")){
            pickedArmoury = gears.get(random.nextInt(0, gears.size()));
        }
        armouries.add(pickedArmoury);
        System.out.println("Your picked Armoury: " + pickedArmoury.getName());

    }

    // A method for when the card is a monster
    public void fight(Cards card){
        System.out.println("Do you want to use an Armoury (Y/N)?");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.nextLine();
        // A switch to runt the methods if the user want
        switch(answer){
            case "y", "Y" -> {
                chooseArmoury(armouries);
                chooseArmoury(handGears);
            }
            case "n", "N" ->{
            }
            default -> {
                System.out.println("Pick one of the options");
                answer = scanner.nextLine();
            }
        }

        // The user fights against the monster
        if (level < card.getLevel()){ // If the user have a lower level then the monster
            System.out.println("You lost the fight");
            level -= card.getLevel();
            System.out.println("Your level is now: " + level);
        } else if (level < card.getLevel() && level == card.getLevel()){ // If the monster has a higher or the same level as the monster
            System.out.println("You won the fight!");
            level += card.getLevel();
            System.out.println("Your level is now: " + level);
        }

    }

    // A method if the user wants to use a gear
    public void chooseArmoury(ArrayList<Gear> list){
        // For loop listing all the gears they have
        for(int i = 0; i < list.size(); i++){
            System.out.println(i+1 + list.get(i).getName());
        }
        // Ask the user if they want to use a gear
        System.out.println("Do you want to use one of the gears? ");
        int number = 0;
        // A loop to make sure the user puts the right value
        while(true){
            Scanner scanner = new Scanner(System.in);
            try{
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e){
                System.out.println("You have to write a number");
            }
        }

        // Add the defence level to the characters level
        level += list.get(number).getDefenseLevel();

    }

    // getters & setters
    public int getLevel() {
        return level;
    }
}
