import javafx.css.Rule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestRules {
    private static Deck deck = new Deck();
    // List cards
    List<Card> player1Cards = new ArrayList<>();
    List<Card> player2Cards = new ArrayList<>();
    private static Player player1;
    private static Player player2;
    private Game game = new Game();
    private Rules rule = new Rules(game);

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

//    @Test
//    public void CheckActionSpecialCardReverseTest() {
//        SpecialCard card = new SpecialCard();
//        card.setValue("reverse");
//        card.setColor("blue");
//        card.setActions(Actions.REVERSE);
//        rule.checkAction(card, player1, player2, deck);
//        //TODO: check reverse action in rule class
//        System.out.print(player1.getTurn());
//        System.out.print(player2.getTurn());
//
//
//    }
//
//    @Test
//    public void CheckActionSpecialCardSkipTest() {
//        SpecialCard card = new SpecialCard();
//        card.setValue("skip");
//        card.setColor("blue");
//        card.setActions(Actions.SKIP_TURN);
//        rule.checkAction(card, player1, player2, deck);
//        //TODO: check skip action in rule class
//        System.out.print(player1.getTurn());
//        System.out.println(player2.getTurn());
//
//
//    }

//    @Test
//    public void CheckActionSpecialCardWildcardTest() {
//        SpecialCard card = new SpecialCard();
//        card.setValue("wild card");
//        card.setColor("none");
//        card.setActions(Actions.CHOOSE_COLOR);
//        rule.checkAction(card, player1, player2, deck);
//        //TODO: check skip action in rule class
//        System.out.println(player1.getTurn());
//        System.out.println(player2.getTurn());
//
//
//    }

    @Test
    public void TurnTrueTest() {
        player1.setTurn(true);
        rule.Turn(player1);
    }

    @Test
    public void TurnFalseTest() {
        player1.setTurn(false);
        rule.Turn(player1);
    }

    @Test
    public void WinnerTest() {
        List<Card> GiulisCard = new ArrayList<>();
        Player player = new Player("Giuli", GiulisCard);

        rule.Winner(player);
    }

    @Test
    public void CheckColorTest() {
        Card card1 = new Card();
        card1.setColor("red");
        game.setRuleColor("blue");
        rule.CheckColor(card1);

    }

    @Test
    public void CheckColorSameTest() {
        Card card1 = new Card();
        card1.setColor("red");
        game.setRuleColor("red");
        rule.CheckColor(card1);

    }
}
