public class Card {
    private Rank rank;
    private Suits suit;

    Card(Suits suit,Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setSuit(Suits suit) {
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suits getSuit() {
        return suit;
    }
}
