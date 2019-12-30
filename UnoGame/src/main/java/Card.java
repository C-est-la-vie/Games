import java.util.Optional;

public class Card {
    private String value;
    private String color;
    private Actions actions;


    Card() {
    }

    public Card(String cardValue, String cardColor, Actions actions) {
        this.value = cardValue;
        this.color = cardColor;
        this.actions = actions;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setActions(Actions actions) {
        this.actions = actions;
    }

    public Actions getActions() {
        return actions;
    }
}
