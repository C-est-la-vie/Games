import java.util.ArrayList;
import java.util.List;

public class Robot extends Player {
    //check the How many cards with the same color I have
    public List<Integer> checkRuleColor(Card lastCard, List<Card> robotCards) {
        // counter. Count how many cards of that color you have.
        List<Integer> colorCount = new ArrayList<>();
        for (int i = 0; i < robotCards.size(); i++) {
            if (robotCards.get(i).getColor().equals(lastCard.getColor())) {
                colorCount.add(i);
            }
        }
        return colorCount;
    }

    //check how many cards with the same color as the card with the same value it has.
    public List<Integer> checkRuleValue(Card lastCard, List<Card> robotCards) {
        List<Integer> valueCount = new ArrayList<>();
        for (int i = 0; i < robotCards.size(); i++) {
            if (robotCards.get(i).getValue().equals(lastCard.getValue())) {
                for (int j = 0; j < robotCards.size(); j++) {
                    if (robotCards.get(i).getColor().equals(robotCards.get(j).getColor())) {
                        valueCount.add(j);
                    }
                }
            }
        }
        return valueCount;
    }

    //Check How many with the same value we have
    public Boolean checkSameValueCard(Card lastCard, List<Card> robotCards) {
        int count = -1;
        for (int i = 0; i < robotCards.size(); i++) {
            if (robotCards.get(i).getValue().equals(lastCard.getValue())) {
                count++;
            }
        }
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    //check if it has wild cards
    public Boolean checkWildCard(List<Card> cards, List<Integer> indexes) {
        for (int x = 0; x < indexes.size(); x++) {
            if (cards.get(indexes.get(x)).getAction().equals(Actions.REVERSE) || cards.get(indexes.get(x)).getAction().equals(Actions.SKIP_TURN)) {
                return true;
            }
        }
        return false;
    }


    //This function will call all the necessary functions to choose a card to play
    public int chooseCard(Card lastCard, List<Card> robotCards) {
        List<Integer> sameColorCount = checkRuleColor(lastCard, robotCards);
        List<Integer> sameValueCount = getSameValueCount(lastCard, robotCards);
        //If it has 0 color and 0 value. return 0
        if (sameColorCount.size() == 0 && sameValueCount.size() == 0) {
            checkActionCards();
            return -1;
        } else if (sameColorCount.size() > sameValueCount.size()) {

        } else if (sameColorCount.size() == sameValueCount.size()) {
            if (checkWildCard(robotCards, sameValueCount)) {
                //Return the index of the card that has the same value.
                return;
            } else if (sameColorCount.size() != 0 && sameValueCount.size() == 0) {
                return sameColorCount.get(randomGetCardToPlay(sameColorCount));
            }
        }


    }

    // get a random card from the valid options to play
    private int randomGetValidCardToPlay(List<Integer> indexes) {
    }

    //Check if it has a +4 or wild to choose color
    private void checkActionCards() {
    }

    private List<Integer> getSameValueCount(Card lastCard, List<Card> robotCards) {
        if (checkSameValueCard(lastCard, robotCards)) {
            return checkRuleValue(lastCard, robotCards);
        } else {
            return checkQuantity(lastCard, robotCards);
        }
    }

    private List<Integer> checkQuantity(Card lastCard, List<Card> robotCards) {
        //Call the checkRuleValue by sending the color of the card that I wanted to check
    }


    //if robot doesn't have any valid colors, and have special cards, then choose option randomly (including draw 1)
    private Boolean randomPlayOrDraw() {
    }
}

