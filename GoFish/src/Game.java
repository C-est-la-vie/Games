import java.util.*;
import static java.util.Map.of;

public class Game {
    public Player player;
    public ComputerPlayer computerPlayer;
    public Deck deck;
    public Boolean turn;
    public Rules rule = new Rules();
    private Messages messages = new Messages();
    Scanner input = new Scanner(System.in);
    private Rank gameRank;
    Map<Rank, String> rankOptionsMap = of(Rank.ACE, "1", Rank.TWO, "2", Rank.THREE, "3", Rank.FOUR, "4", Rank.FIVE, "5", Rank.SIX, "6", Rank.SEVEN, "7", Rank.EIGHT, "8", Rank.NINE, "9", Rank.TEN, "10");
    Map<Rank, String> rankOptionsExtended = of(Rank.JACK, "11", Rank.QUEEN, "12", Rank.KING, "13");

    public void startGame() {
        this.deck = new Deck();
        deck.shuffle();
        setTurn();
        this.player = new Player(deck.deal(), getTurn());
        this.computerPlayer = new ComputerPlayer(deck.deal(), !getTurn());
    }

    public void play() {
        do {
            if (turn) {
                messages.playerTurn();
                managePlayerMove();
            } else {
                messages.computerTurn();
                manageComputerPlayerMove();
            }
        } while (deck.getCards().size() != 1);
        rule.getWinner(player.count,computerPlayer.count);
        messages.winMessage();
        System.exit(1);
    }

    private void manageComputerPlayerMove() {
        computerPlayer.chooseRank();
        gameRank = computerPlayer.getRank();
        computerPlayer.checkForMatches();
        if (!rule.checkRank(player.getCards(), gameRank)) {
            System.out.println("Rank: " + gameRank + "!");
            messages.goFishing();
            computerPlayer.getCards().add(deck.drawACard());
            this.turn = true;
        } else {
            System.out.println("Rank: " + gameRank + "!");
            messages.takingCards();
            takeRankCards(computerPlayer.getCards(), player.getCards());
        }

    }

    public void managePlayerMove() {
            messages.showCards(player.getCards());
            messages.options();
            //CheckForMatches.
        //TODO: Message that says about the matches.
        if(player.checkForMatches()){
            messages.gotAmatched();
        }
            setRank();
            checkComputerPlayersCard();
    }


    private void checkComputerPlayersCard() {
        if (!rule.checkRank(computerPlayer.getCards(), gameRank)) {
            messages.goFishing();
            messages.computerDidntHaveACardMessage(gameRank);
            messages.drawACard();
            player.getCards().add(deck.drawACard());
            turn = false;
        } else {
            messages.takingComputersCards();
            takeRankCards(player.getCards(), computerPlayer.getCards());
        }
    }

    private void setRank() {
        String rank;
        do {
            messages.whichRank();
            rank = input.next();
        } while (!rule.checkValidRank(rank));
        setGameRank(rank);
       if(!rule.checkRank(player.getCards(), gameRank)){
           setRank();
       }

    }

    private void setGameRank(String rank) {
        if (rankOptionsMap.containsValue(rank)) {
            for (Map.Entry<Rank, String> map : rankOptionsMap.entrySet()) {
                if (map.getValue().equals(rank)) {
                    this.gameRank = map.getKey();
                    break;
                }
            }
        } else if (rankOptionsExtended.containsValue(rank)) {
            for (Map.Entry<Rank, String> map : rankOptionsExtended.entrySet()) {
                if (map.getValue().equals(rank)) {
                    this.gameRank = map.getKey();
                    break;
                }
            }
        }
    }




    public void setTurn() {
        Random gameTurn = new Random();
        this.turn = gameTurn.nextBoolean();
    }

    public Boolean getTurn() {
        return turn;
    }

    public void takeRankCards(List<Card> myCards, List<Card> cards) {
        List<Card> takenCards = new ArrayList<Card>();
        for (Card card : cards) {
            if (card.getRank().equals(gameRank)) {
                myCards.add(card);
                takenCards.add(card);
            }
        }
        for (Card card : takenCards){
            cards.remove(card);
        }
    }

    public ComputerPlayer getComputerPlayer() {
        return computerPlayer;
    }

    public Player getPlayer() {
        return player;
    }

    public Deck getDeck() {
        return deck;
    }
}
