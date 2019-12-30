import java.util.*;

public class Deck {
    private List<Card> cards;
    private final Map<Integer, String> colors =
            Map.of(1, "red", 2, "blue", 3, "green", 4, "yellow");

    Deck() {
        cards = new ArrayList<>();
        for (String color : colors.values()) {
            MakingCards(cards, color);
            MakingSpecialCards(cards, color, Actions.ADD_TWO, "+2", 2);
            MakingSpecialCards(cards, color, Actions.SKIP_TURN, "Skip", 2);
            MakingSpecialCards(cards, color, Actions.REVERSE, "reverse", 2);
        }
        MakingSpecialCards(cards, "none", Actions.CHOOSE_COLOR, "wild", 4);
        MakingSpecialCards(cards, "none", Actions.ADD_FOUR, "+4", 4);
    }



public Card StartCard(){
        Card card = cards.get(0);
        cards.remove(0);
        return card;
}
    public void DrawCard(List<Card> playerCard, int times) {
        for (int x = 0; x < times; x++) {
            playerCard.add(cards.get(0));
            cards.remove(0);
        }
    }

    public void mixCard() {
        Random random = new Random();
        for (int i = 0; i < 108; i++) {
            int newIndex = i + random.nextInt(108 - i);
            //switching
            Card card = new Card();
            card.setColor(cards.get(i).getColor());
            card.setValue(cards.get(i).getValue());
            cards.get(i).setValue(cards.get(newIndex).getValue());
            cards.get(i).setColor(cards.get(newIndex).getColor());
            cards.get(newIndex).setColor(card.getColor());
            cards.get(newIndex).setValue(card.getValue());
        }
    }
//TODO: Change this to DealsCards
    public List<Card> DealCards() {
        List<Card> playerCard = new ArrayList<>();
        for (int i = 0; i < 7; i++) {

            playerCard.add(cards.get(0));
            cards.remove(0);
        }
        return playerCard;
    }
    private void MakingCards(List<Card> cards, String color) {
        var y = 0;
        for (int index = 0; index < 19; index++, y++) {
            var card = new Card(y + "", color);
            cards.add(card);
            if (y == 9) {
                y = 0;
            }
        }
    }

    private void MakingSpecialCards(List<Card> cards, String color, Actions action, String value, int n) {
        for (int index = 0; index < n; index++) {
            var specialCard = new SpecialCard();
            specialCard.setColor(color);
            specialCard.setValue(value);
            specialCard.setActions(action);
            cards.add(specialCard);
        }
    }

}


