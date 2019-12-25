import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Rules rule;
    private String color;
    private String name;

    //Welcome Message
    public void WelcomeMessage() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nWelcome to this unofficial UNO Game! \nWhat's your name?\n Enter Name: ");
        this.name = input.next();
        Menu();
    }

    //Menu
    public void Menu() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nChoose one option from below" +
                "\n 1 : Start" +
                "\n 2 : Read Instructions" +
                "\n 3 : End Game");
        var option = input.nextInt();
        switch (option) {
            case 1:
                Start();
                break;
            case 2:
                Instructions();
                break;
            case 3:
                EndGame();
                break;
            default:
                Menu();
        }
    }
    // Create player.
    public void CreatePlayer(String name) {
     List<Card> playerCards = new ArrayList<>();
     Player player = new Player(name, playerCards);
    }

    private void Start() {
        CreatePlayer(name);
        CreatePlayer("Robot");

    }


    //Display Instructions.


    private void Instructions() {
    }


    private void EndGame() {
    }




    //End Message.

    //EndGame
    // Do you want to play again.

    //Play Card
    public void PlayCard(Player player, Player player2, Deck deck) {
        Scanner input = new Scanner(System.in);
        if (player.getTurn()) {
            System.out.print("Play a card: ");
            var index = input.nextInt() - 1;
            //Check that index is on array boundary

            // get card
            var card = player.getCards().get(index);
            player.getCards().remove(index);
            rule.checkAction(card, player, player2, deck);
        }


    }
// CheckArrayBoundary


    //Set rule color
    public String getRuleColor() {
        return color;
    }

    public void setRuleColor(String color) {
        this.color = color;
    }
}
