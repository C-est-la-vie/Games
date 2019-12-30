import java.util.List;
import java.util.Scanner;

public class Rules {
   private Game game;

//TODO: Do we need this here?
   Rules(Game game){
       this.game = game;
   }
    // Action’s rules.
    // method call Action
    public void checkAction(Card card, Player player, Player player2, Deck deck) {
        //When we have add_two or add four, use the method AddCard
        if (card.getActions().equals(Actions.ADD_TWO)) {
            AddCard(card, player2, deck);
            player.setTurn(true);
            player.setTurn(false);
        }
        else if (card.getActions().equals(Actions.ADD_FOUR)) {
                AddCard(card, player2, deck);
                ChooseColor(card);
                player.setTurn(true);
                player2.setTurn(false);
        }
        //When we have wild card, use the method ChooseColor
        else if (card.getActions().equals(Actions.CHOOSE_COLOR)) {
            ChooseColor(card);
            player.setTurn(false);
            player2.setTurn(true);
        }
        //When we have reverse card, use the method ChangeTurns
        else if (card.getActions().equals(Actions.REVERSE) || card.getActions().equals(Actions.SKIP_TURN)) {
            player.setTurn(true);
            player2.setTurn(false);
            game.PlayCard();
        } else {
            player.setTurn(false);
            player2.setTurn(true);
        }

    }



    //ADD_TWO, ADD_FOUR, CHOOSE_COLOR, SKIP_TURN, REVERSE;
    public void AddCard(Card card, Player player, Deck deck) {
        if (card.getActions().equals(Actions.ADD_TWO)) {
            deck.DrawCard(player.getCards(), 2);
        } else if (card.getActions().equals(Actions.ADD_FOUR)) {
            deck.DrawCard(player.getCards(), 4);

        }
    }

    public void ChooseColor(Card card) {
        Scanner input = new Scanner(System.in);
        System.out.print("Choose a color: red (r), blue (b), green (g), yellow (y)");
        String color = input.next().toLowerCase().substring(0, 1);
        switch (color) {
            case "r":
                color = "red";
                break;
            case "b":
                color = "blue";
                break;
            case "g":
                color = "green";
                break;
            case "y":
                color = "yellow";
                break;
            default:
                System.out.println("The color entered is not valid. Try again");
                ChooseColor(card);
        }
        game.getLastCard().setColor(color);
        game.ChangeColorMessage();
    }

    // Turns.
    public void Turn(Player player) {
        //message
        if (!player.getTurn()) {
            System.out.println("It is not your turn");
        }
    }

    //if player has 0 cards then wins
    public void Winner(Player player) {
        if (player.getCards().isEmpty()) {
            System.out.println(player.getName() + " wins!");
            //end game method
        }
    }
    
//Color
    public boolean CheckColor(Card card) {
        //if the card is invalid, print the message.
        if (!card.getColor().equals(game.getLastCard().getColor()) && !card.getValue().equals(game.getLastCard().getValue())) {
            System.out.print("This card is not " + game
                    .getLastCard().getValue() +" "+ card.getColor() + ".\n Please try again.");
            return false;
        } else {
            return true;
        }
    }


}
