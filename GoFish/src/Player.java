import java.util.List;

public class Player {
    public List<Card> cards;
    public Rank rank;
    public Boolean turn;
    public int count;

    Player() {
    }

    Player(List<Card> cards, Boolean turn) {
        this.cards = cards;
        this.turn = turn;
        this.count = 0;
    }

    public List<Card> getCards() {
        return cards;
    }

    public Rank getRank() {
        return rank;
    }

    /**
     * Check for 4 identical card on Player's deck
     **/
    public Boolean checkForMatches() {
        Rules rules = new Rules();
        int count = 0;
        for (Rank rank : Rank.values()) {
            if (rules.match(cards, rank)) {
                setCount();
                return true;
            }
        }
        return false;
    }
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void setTurn(Boolean turn) {
        this.turn = turn;
    }

    public Boolean getTurn() {
        return turn;
    }

    public void setCount() {
        this.count +=1 ;
    }

    public int getCount() {
        return count;
    }
}
