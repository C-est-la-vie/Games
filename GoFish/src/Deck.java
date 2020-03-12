import java.util.*;

public class Deck {
    private List<Card> cards = new ArrayList<Card>();

    Deck() {
        createDeck();
    }

    private void createDeck() {
        for (Suits suit : Suits.values()) {
            for (Rank rank : Rank.values()) {
                this.cards.add(new Card(suit, rank));
            }
        }
    }

    public Card drawACard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Random random = new Random();
        for (int i = 0; i < cards.size(); i++) {
            int rIndex = random.nextInt(cards.size() - i);
            Collections.swap(cards, i, rIndex);
        }
    }

    public List<Card> deal() {
        List<Card> playerCards = new ArrayList<Card>();
        for (int i = 0; i < 7; i++) {
            playerCards.add(cards.get(i));
            cards.remove(i);
        }
        return playerCards;
    }
}
