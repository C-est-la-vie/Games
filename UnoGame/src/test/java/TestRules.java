import javafx.css.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRules {
    private static Deck deck = new Deck();
    // List cards
    List<Card> player1Cards = new ArrayList<>();
    List<Card> player2Cards = new ArrayList<>();
    private static Player player1;
    private static Player player2;
    private Game game = new Game();
    private Rules rule = new Rules();

    @BeforeAll
    public void CreatePlayers(){
        deck.mixCard();
        player1Cards = deck.StartCard();
        player2Cards = deck.StartCard();
        player1 = new Player("Robot", player1Cards);
        player2 = new Player("human", player2Cards);
    }

    @Test
    public void CheckActionSpecialCardAddTwoTest() {
        SpecialCard card = new SpecialCard();
        card.setValue("plus2");
        card.setColor("blue");
        card.setActions(Actions.ADD_TWO);
        rule.checkAction(card, player1, player2, deck);
        for (int i = 0; i < player2.getCards().size(); i++) {
            System.out.print(player2.getCards().get(i).getValue() + " ");
        }

    }

    @Test
    public void CheckActionSpecialCardAddFourTest() {
        SpecialCard card = new SpecialCard();
        card.setValue("plus4");
        card.setColor("blue");
        card.setActions(Actions.ADD_FOUR);
        rule.checkAction(card, player1, player2, deck);
        for (int i = 0; i < player2.getCards().size(); i++) {
            System.out.print(player2.getCards().get(i).getValue() + " ");
        }

    }

    @Test
    public void CheckActionSpecialCardReverseTest() {
        SpecialCard card = new SpecialCard();
        card.setValue("reverse");
        card.setColor("blue");
        card.setActions(Actions.REVERSE);
        rule.checkAction(card, player1, player2, deck);
        //TODO: check reverse action in rule class
        System.out.print(player1.getTurn());
        System.out.print(player2.getTurn());


    }

    @Test
    public void CheckActionSpecialCardSkipTest() {
        SpecialCard card = new SpecialCard();
        card.setValue("skip");
        card.setColor("blue");
        card.setActions(Actions.SKIP_TURN);
        rule.checkAction(card, player1, player2, deck);
        //TODO: check skip action in rule class
        System.out.print(player1.getTurn());
        System.out.println(player2.getTurn());


    }
}
