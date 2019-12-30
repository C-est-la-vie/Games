import java.util.List;

public class Player {
    private  String name;
    private List<Card> cards;
    private  boolean turn;

    Player() { }
    //TODO: Do I need to pass or can I just create cards?
    Player(String name, List<Card> cards) {
        this.name = name;
        this.cards = cards;
        this.turn = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setTurn(boolean turn){
        this.turn = turn;
    }
    public boolean getTurn(){
        return turn;
    }
}
