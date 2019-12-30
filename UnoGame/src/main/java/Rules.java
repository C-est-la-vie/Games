import java.util.List;
import java.util.Scanner;

public class Rules {
    private Game game;

    Rules(Game game) {
        this.game = game;
    }

    // Action’s rules.
    // method call Action
    public void checkAction(Card card, Player player, Player player2, Deck deck) {
        //When we have add_two or add four, use the method AddCard
        if (card.getActions().equals(Actions.ADD_TWO) || card.getActions().equals(Actions.ADD_FOUR)) {
            AddCard(card, player2, deck);
            player.setTurn(true);
            player2.setTurn(false);
        }
        //When we have wild card, use the method ChooseColor
        else if (card.getActions().equals(Actions.CHOOSE_COLOR)) {
            player.setTurn(false);
            player2.setTurn(true);
        }
        //When we have reverse card, use the method ChangeTurns
        else if (card.getActions().equals(Actions.REVERSE) || card.getActions().equals(Actions.SKIP_TURN)) {
        } else {
            player.setTurn(false);
            player2.setTurn(true);
        }
        if (card.getColor().equals("none") && !player.getName().equals("robot")) {
            ChooseColor(card);
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
        if (color.equals("r") || color.equals("b") || color.equals("g") || color.equals("y")) {

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
            }
            game.getLastCard().setColor(color);
            card.setColor(color);
            game.ChangeColorMessage();
        } else {
            System.out.println("\nThat is not a color...\n");
            ChooseColor(card);
        }
    }

    // Turns.
    //@unused
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
            game.Menu();
        }
    }

    //Color
    public boolean CheckColor(Card card) {
        //if the card is invalid, print the message.
        if (!card.getColor().equals(game.getLastCard().getColor()) && !card.getValue().equals(game.getLastCard().getValue()) && !card.getColor().equals("none")) {
            System.out.print("This card doesn't have the value of " + game
                    .getLastCard().getValue() + " or it's " + game.getLastCard().getColor() + ".\n Please try again.\n");
            return false;
        } else {
            return true;
        }
    }


}
