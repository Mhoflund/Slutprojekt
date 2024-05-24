import java.util.Scanner;

public class GameLoop {
    Character player;

    // Constructor
    public GameLoop(){
        setUp();
        gameLoop();
    }

    // Method for the gameloop
    private void gameLoop() {
        while(player.getLevel() > 0){
            player.pickCard();
            Scanner bob = new Scanner(System.in);
            bob.nextLine();
        }
    }

    // Method for the setup for the character
    private void setUp() {
        player = new Character(1);
        player.createDeck();
        player.createGears();
    }
}
