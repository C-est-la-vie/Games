import java.util.Scanner;

public class Game {
    private Rules rule;
    private String color;
    //Play Card
    public void PlayCard(Player player,Player player2, Deck deck){
        Scanner input = new Scanner(System.in);
        if(player.getTurn()) {
            System.out.print("Play a card: ");
            var index = input.nextInt() - 1;
            //Check that index is on array boundary

            // get card
            var card = player.getCards().get(index);
            player.getCards().remove(index);
            rule.checkAction(card, player, player2, deck);
        }


    }
// CheckArrayBoundary
public String getRuleColor(){
    return color;
}
public  void setRuleColor(String color){
        this.color = color;
}
}
