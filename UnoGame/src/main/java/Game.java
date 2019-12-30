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
    //TODO: When people sets a letter show try again
    public void Menu() {
        Scanner input = new Scanner(System.in);
        System.out.print("\nChoose one option from below" +
                "\n 1 : Start game from 0 " +
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
    }


    private void Start() {
        this.deck = new Deck();
        deck.mixCard();
        CreatePlayer(name, deck);
        ShowFirstCard();
        SetRandomTurn();
        Play();

    }

    public void Play() {
        System.out.println("THis is the last card : " + this.card.getColor() + " " + this.card.getValue());
        System.out.println("This is player's turn: " + player.getTurn() );
        System.out.println("This is robo's turn: " + robot.getTurn() );
        if (player.getTurn()) {
            System.out.print("\nIt's your turn\n");
            PlayCard();
        } else {
            RobotsPlay();
        }
    }

    private void RobotsPlay() {
        int cardToPlay = robotPlayer.chooseCard(card, robot.getCards());
        if (cardToPlay < 0) {
            deck.DrawCard(robot.getCards(), 1);
        } else {
            var myCard = robot.getCards().get(cardToPlay);
            this.card.setColor(myCard.getColor());
            this.card.setValue(myCard.getValue());
            robot.getCards().remove(robot.getCards().get(cardToPlay));
            if (myCard.getActions().equals(Actions.CHOOSE_COLOR)) {
                String color = robotPlayer.ChooseColor(robot.getCards());
                this.card.setColor(color);
                ChangeColorMessage();
                robot.setTurn(false);
                player.setTurn(true);
            } else {
                rule.checkAction(myCard, robot, player, deck);
            }
            Play();
        }
    }
  public void ChangeColorMessage(){
      System.out.print("\n The color now is " + card.getColor() +"\n");
  }

        private void SetRandomTurn () {
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

        private void ShowPlayerCard () {
            System.out.print("\n These are your cards: \n");
            var i = 1;
            for (Card playerCard : player.getCards()) {
                System.out.println(i + ": " + playerCard.getValue() + " " + playerCard.getColor());
                i++;
            }

        }

        private void ShowFirstCard () {
            var card = deck.StartCard();
            this.card = card;
            System.out.print(" _ _ _ _ \n" +
                    "|        |\n" +
                    "|" + card.getValue() + " " + card.getColor() + "|\n" +
                    "|_ _ _ _ |\n");
        }


        //Display Instructions.


        private void Instructions () {
            System.out.print("\nInstructions: " +
                    "During your turn, you'll see a message telling you that it's your time to play.\n" +
                    "Enter the number on the left side of the card that you want to play.\n" +
                    "If you don't have a card that you can play then enter \"d\" to draw a card from the pile.\n" +
                    "Have fun!!\n");
            Menu();
        }


        private void EndGame () {
            System.out.print("\nThank you for playing\n");
            System.exit(1);
        }

        //Play Card
        public void PlayCard () {
            ShowPlayerCard();
            Scanner input = new Scanner(System.in);
            if (player.getTurn()) {
                System.out.print("Play a card: ");
                var index = input.nextInt() - 1;
                //Check that index is on array boundary
                CheckArrayBoundary(index);
                // get card
                var myCard = player.getCards().get(index);
                player.getCards().remove(player.getCards().get(index));
                rule.checkAction(myCard, player, robot, deck);
                this.card.setColor(myCard.getColor());
                this.card.setValue(myCard.getValue());
                Play();
            }


        }

        // CheckArrayBoundary
        private void CheckArrayBoundary ( int number){
            if (number < 0 || number >= player.getCards().size()) {
                System.out.print("\n " + number + "is not a valid number");
                PlayCard();
            }
        }


        //last card played
        public Card getLastCard () {
            return card;
        }

        public void setLastCard (Card card){
            this.card = card;

        }
        // Say UNO when left card is only one.
        public void Uno () {
            if (player.getCards().size() == 1 || robot.getCards().size() == 1) {
                uno = true;
                System.out.println("Uno!");
            }
        }

        public void setUno ( boolean uno){
            this.uno = uno;
        }

        public boolean getUno () {
            return uno;
        }

        // Create player.
        private void CreatePlayer (String name, Deck deck){
            player = new Player(name, deck.DealCards());
            robot = new Player("robot", deck.DealCards());
            robotPlayer.setPlayer(robot);
        }
        public String getPlayerName () {
            return name;
        }

    public void setRule(Rules rule) {
        this.rule = rule;
    }
}
