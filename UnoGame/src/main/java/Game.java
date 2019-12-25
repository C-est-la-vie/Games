public class Game {
    //private Rules rule;
    //Play Card
    public void PlayCard(Player player, Card card){
        if(player.getTurn()){
            player.getCards().remove(card);
        }
        //rule.checkAction(,player,)

    }

}
