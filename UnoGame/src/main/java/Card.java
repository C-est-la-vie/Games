import java.util.Optional;

public class Card {
    private String value;
    private String color;
    private Optional<Actions> actions;


    Card() {
    }

    public Card(String cardValue, String cardColor) {
        this.value = cardValue;
        this.color = cardColor;
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

    public void setActions(Optional<Actions> actions) {
        this.actions = actions;
    }

    public Optional<Actions> getActions() {
        return actions;
    }
}
