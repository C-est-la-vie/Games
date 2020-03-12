import java.util.List;

public class Messages {

    public void welcomeMessage() {
        System.out.println("Welcome to start playing press (S) to read the instructions press (I)");
    }
  public void winMessage(){
      System.out.println("win!!. It was a good game");
  }
    public void instructions() {
        System.out.println(" This game is called Go Fish ");
        System.out.println(" On your turn you can select the rank \n" +
                "of a card that you already have and ask the other player \n" +
                "to give you all his cards with the rank that you selected \n" +
                "if you were able to fish (get some cards) then \n" +
                "you can choose a different rank and ask again \n" +
                "your turn will be over once that the other player says \"Go fishing\" \n" +
                "meaning that he doesn't any card with the rank that you asked for \n" +
                "and you'll need to draw a card");
    }

    public void options() {
        System.out.println("Choose a rank\n");
    }

    public void whichRank(){
        System.out.println("What rank would you like to choose?\n" +
                "This is a guide for you: " +
                "ACE (1), " +
                "TWO (2), " +
                "THREE (3), " +
                "FOUR (4), " +
                "FIVE (5), " +
                "SIX (6), " +
                "SEVEN (7), " +
                "EIGHT (8), " +
                "NINE (9), " +
                "TEN (10), " +
                "JACK (11), " +
                "QUEEN (12), " +
                "KING (13) \n" +
                "Choose a rank from your cards and then type the number next to the rank on the guide: \n");
    }

    public void showCards(List<Card> cards){
        System.out.println("Your cards");
        for (Card card : cards){
            System.out.print(card.getSuit() + " " + card.getRank() + " | ");
        }
        System.out.print("\n");
    }
    public void goFishing(){
        System.out.println("Go Fishing!");
    }
    public void drawACard(){
        System.out.println("You draw a card");
    }
    public void computerDidntHaveACardMessage(Rank gameRank){
        System.out.println("Computer didn't have a card with " + gameRank + "!");
    }
    public void takingCards(){
        System.out.println("I'll take your cards");
    }
    public void gotAmatched(){
        System.out.println("You got a set of 4 cards with the same rank! \n We have taken the set. \n ");
    }
    public void takingComputersCards(){
        System.out.println("Good Job, you got some cards!");
    }
    public void playerTurn(){
        System.out.println("It's your turn");
    }
    public void computerTurn(){
        System.out.println("It's the computer's turn");
    }
}
