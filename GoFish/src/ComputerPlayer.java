import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {


    public ComputerPlayer(List<Card> deal, boolean b) {
        super(deal, b);
    }

    /**
     * Choose randomly a rank to ask for
     **/
    public void chooseRank() {
        Random index = new Random();
        super.setRank(super.cards.get(index.nextInt(super.cards.size() - 1)).getRank());
    }


}
