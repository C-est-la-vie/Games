import java.util.Random;
import java.util.Scanner;

public class Game {
    private Rules rule;
    private Card card;
    private String name;
    private Deck deck;
    private Player player;
    private static Player robot;
    private boolean uno;
    private Robot robotPlayer;

    Game(Robot robot) {
        this.robotPlayer = robot;
    }

    //Welcome Message
    public void WelcomeMessage() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nWelcome to this unofficial UNO Game! \nWhat's your name?\n Enter Name: ");
        this.name = input.next();
    }

    //Menu
    public void Menu() {
        try {
            Scanner input = new Scanner(System.in);
            System.out.print("\nChoose one option from below" +
                    "\n 1 : Start game " +
                    "\n 2 : Read Instructions" +
                    "\n 3 : End Game\n");
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
        } catch (Exception e) {
            System.out.println("That is not a valid option. Try with a number from 1 to 3");
        }finally {
            Menu();
        }

    }


    private void Start() {
        this.deck = new Deck();
        deck.mixCard();
        CreatePlayer(name, deck);
        setFirstCard();
        SetRandomTurn();
        Play();

    }

    public void Play() {
        if (player.getTurn()) {
            rule.Winner(robot);
            System.out.print("\nIt's your turn\n");
            PlayCard();

        } else {
            rule.Winner(player);
            RobotsPlay();

        }
    }

    private void RobotsPlay() {
        System.out.println("\nRobot's card");
        showRobotsCards();
        int cardToPlay = robotPlayer.chooseCard(card, robot.getCards());
        if (cardToPlay < 0) {
            deck.DrawCard(robot.getCards(), 1);
            robot.setTurn(false);
            player.setTurn(true);
        } else {
            var myCard = robot.getCards().get(cardToPlay);
            this.card.setColor(myCard.getColor());
            this.card.setValue(myCard.getValue());
            robot.getCards().remove(robot.getCards().get(cardToPlay));
            if (myCard.getColor().equals("none")) {
                String color = robotPlayer.ChooseColor(robot.getCards());
                this.card.setColor(color);
                ChangeColorMessage();
                robot.setTurn(false);
                player.setTurn(true);
            }
            rule.checkAction(myCard, robot, player, deck);
        }
        Uno(robot);
        Play();
    }

    public void ChangeColorMessage() {
        System.out.print("\n The color now is " + card.getColor() + "\n");
    }

    private void SetRandomTurn() {
        Random random = new Random();
        int number = random.nextInt(10);
        if (number % 2 == 0) {
            player.setTurn(false);
            robot.setTurn(true);
        } else {
            player.setTurn(true);
            robot.setTurn(false);
        }
    }

    private void ShowPlayerCard() {
        System.out.print("\n These are your cards: \n");
        var i = 1;
        for (Card playerCard : player.getCards()) {
            System.out.println(i + ": " + playerCard.getValue() + " " + playerCard.getColor());
            i++;
        }

    }

    private void setFirstCard() {
        this.card = deck.StartCard();

    }

    private void showLastCard() {
        System.out.print(" _ _ _ _ \n" +
                "|        |\n" +
                "|" + this.card.getValue() + " " + this.card.getColor() + "|\n" +
                "|_ _ _ _ |\n");
    }

    //Display Instructions.


    private void Instructions() {
        System.out.print("\nInstructions: " +
                "During your turn, you'll see a message telling you that it's your time to play.\n" +
                "Enter the number on the left side of the card that you want to play.\n" +
                "If you don't have a card that you can play then enter \"0\" to draw a card from the pile.\n" +
                "Have fun!!\n");
        Menu();
    }


    public void EndGame() {
        System.out.print("\nThank you for playing\n");
        System.exit(1);
    }

    //Play Card
    public void PlayCard() {
        showLastCard();
        ShowPlayerCard();
        Scanner input = new Scanner(System.in);
        if (player.getTurn()) {
            System.out.println("Choose 0 to draw a Card");
            System.out.print("Play a card: \n");

            var index = input.nextInt() - 1;

            if (index == -1) {
                deck.DrawCard(player.getCards(), 1);
                robot.setTurn(true);
                player.setTurn(false);
            } else {
                //Check that index is on array boundary
                CheckArrayBoundary(index);
                // get card
                var myCard = player.getCards().get(index);
                //Check that card respect the color or value of the las card.
                if (rule.CheckColor(myCard)) {
                    player.getCards().remove(player.getCards().get(index));
                    rule.checkAction(myCard, player, robot, deck);
                    this.card.setColor(myCard.getColor());
                    this.card.setValue(myCard.getValue());
                } else {
                    PlayCard();
                }
            }
            Uno(player);
            Play();
        }
    }

    // CheckArrayBoundary
    private void CheckArrayBoundary(int number) {
        if (number < 0 || number >= player.getCards().size()) {
            System.out.print("\n " + number + "is not a valid number");
            PlayCard();
        }
    }


    //last card played
    public Card getLastCard() {
        return card;
    }

    public void setLastCard(Card card) {
        this.card = card;

    }

    // Say UNO when left card is only one.
    public void Uno(Player player) {
        if (player.getCards().size() == 1) {
            uno = true;
            System.out.println(player.getName() + ": Uno!");
            setUno(true);
        } else {
            setUno(false);
        }
    }

    public void setUno(boolean uno) {
        this.uno = uno;
    }

    public boolean getUno() {
        return uno;
    }

    // Create player.
    private void CreatePlayer(String name, Deck deck) {
        player = new Player(name, deck.DealCards());
        robot = new Player("robot", deck.DealCards());
        robotPlayer.setPlayer(robot);
    }

    public String getPlayerName() {
        return name;
    }

    public void setRule(Rules rule) {
        this.rule = rule;
    }

    //For Testing purposes we want to see the Robot's cards after all the tests
    public void showRobotsCards() {
        for (Card card : robot.getCards()) {
            System.out.print(" " + card.getValue() + " " + card.getColor());
        }

    }
}
