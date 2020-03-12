import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rules {
    /**
     * Check that the player has a card with the game rank
     **/
    public Boolean checkRank(List<Card> cards, Rank rank) {
        for (Card card : cards) {
            if (card.getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

    /**
     * The player who's turn needs to set a rank
     **/
    public Boolean checkTurn(Boolean turn) {
        return turn;
    }

    /**
     * If the player doesn't have any card of the set rank then they can say Go Fish
     **/
    public Boolean goFish(List<Card> cards, Rank rank) {
        for (Card card : cards) {
            if (card.getRank().equals(rank)) {
                return false;
            }
        }
        return true;
    }

    /**
     * If the person that you asked for said Go Fish you'll need to draw a card
     **/
    public void drawCard(List<Card> cards, List<Card> deck) {
        cards.add(deck.get(0));
        deck.remove(0);
    }

    /**
     * Having four cards is a match and you need to put the cards down
     **/
    public Boolean match(List<Card> cards, Rank rank) {
        int count = 0;
        for (Card card : cards) {
            if (card.getRank().equals(rank)) {
                count++;
            }
        }
        return count == 4;
    }

    /**
     * Wins the one that has more sets of 4 cards
     **/

    public String getWinner(int playerCount, int robotCount) {
        if (playerCount > robotCount) {
            return "you";
        } else if (playerCount == robotCount) {
            return "tied";
        } else {
            return "I";
        }
    }
    /**
     * Ranks should be between 1 - 13
     **/
    public boolean checkValidRank(String rank) {
        Pattern p = Pattern.compile("[1-9]");
        Pattern secondPatter = Pattern.compile("[1-9][0-3]");
        Matcher matcher = p.matcher(rank);
        Matcher secondMatcher = secondPatter.matcher(rank);
        return (matcher.find() || secondMatcher.find());
    }
}
