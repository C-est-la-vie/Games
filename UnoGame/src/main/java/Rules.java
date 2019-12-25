import java.util.List;
import java.util.Scanner;

public class Rules {
    Game game = new Game();

    // Action’s rules.
    // method call Action
    public void checkAction(SpecialCard card, Player player, Player player2, Deck deck) {
        //When we have add_two or add four, use the method AddCard
        if (card.getActions().equals(Actions.ADD_TWO) || card.getActions().equals(Actions.ADD_FOUR)) {
            AddCard(card, player2, deck);
            game.PlayCard(player, player2, deck);

        }
        //When we have wild card, use the method ChooseColor
        else if (card.getActions().equals(Actions.CHOOSE_COLOR)) {
            ChooseColor(card);
            player.setTurn(false);
        }
        //When we have reverse card, use the method ChangeTurns
        else if (card.getActions().equals(Actions.REVERSE) || card.getActions().equals(Actions.SKIP_TURN)) {
            game.PlayCard(player, player2, deck);
        }

    }

    public void checkAction(Card card, Player player, Player player2, Deck deck) {
        player.setTurn(false);
    }

    //ADD_TWO, ADD_FOUR, CHOOSE_COLOR, SKIP_TURN, REVERSE;
    public void AddCard(SpecialCard card, Player player, Deck deck) {
        List<Card> playerCards = player.getCards();
        if (card.getActions().equals(Actions.ADD_TWO)) {
            deck.DrawCard(playerCards, 2);
        } else if (card.getActions().equals(Actions.ADD_FOUR)) {
            deck.DrawCard(playerCards, 4);
        }
    }

    public void ChooseColor(SpecialCard card) {
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
        game.setRuleColor(color);


    }

    public void ChangeTurns(Player player) {

    }

    // Turns.
    public void Turn(Player player) {
        player.getTurn();
        //message
        if (!player.getTurn()) {
            System.out.println("It is not your turn");
        }
    }

    //if player has 0 cards then wins
    
//Color
    public boolean CheckColor(Card card) {
        //if the card is invalid, print the message.
        if (!card.getColor().equals(game.getRuleColor())) {
            System.out.print("This card is not " + game
                    .getRuleColor() + ".\n Please try again.");
            return false;
        } else {
            return true;
        }
    }


}