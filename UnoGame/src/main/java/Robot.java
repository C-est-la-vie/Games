import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robot extends Player {
    //This function will call all the necessary functions to choose a card to play
    public int chooseCard(Card lastCard, List<Card> robotCards) {
        // Check If my opponent is about to win
        int last = LastMovement(lastCard, robotCards);
        if (last >= 0) {
            return last;
        }   //If I have cards with the same color
        else if (checkCardsWithSameColor(lastCard.getColor(), robotCards)) {
            //Count how many I have
            List<Integer> sameColorCount = checkRuleColor(lastCard, robotCards);
            //Check if I have cards with the same value;
            if (checkForCardValue(robotCards, lastCard.getValue())) {
                //How many cards with the same value & it should be different color.
                List<Integer> valueCount = checkRuleValue(lastCard, robotCards);
                return -4;
                //More details
                //TODO: Working from here now.
            } else {
                //if I just have the same color then I want to know if I have a special card
                if (checkWildCard(sameColorCount, robotCards)) {
                    // If I do then I want to play it
                    return FindCardByUsingAListInteger(sameColorCount, robotCards);
                } else {
                    //If I don't have a special card with the same color that I can use then
                    // Choose any of the same color
                    return randomChooseCardToPlay(sameColorCount);
                }
            }
            //}
        }//If I don't have cards with the same color then
        //Check to see if I have cards with the same value
        else if (checkForCardValue(robotCards, lastCard.getValue())) {
            //If I do have, how many cards with the same value?
            //If I have more than 1
            // TODO: Finishing this options, there is the possibility that the cards have the same color
            //or of having 3 cards with the same value
//            if (checkDuplicateValueCard(lastCard, robotCards)) {
//// I want to choose the one that with benefit me the most
//                // Check quantity
//                //TODO: I'm working here
//                String[] colors = getColorsOfDuplicateValues();
//                int fistColor = checkQuantity(colors[0],robotCards);
//                int secondColor = checkQuantity(colors[1],robotCards);
//                if(fistColor > secondColor){
//                    //I want to choose to use the value that has the first color
//
//                }
            //          } else {
            // If I just have one with the same value.
            //Then play that one.
            return FindIndexCardByValue(robotCards, lastCard.getValue());
        }

        //If I have nothing check to see if I have a none color card
        else if (

                checkCardsWithSameColor("none", robotCards)) {
            //If I have then Choose that one
            return getNoneColorCard(robotCards);

        }

        //If I don't then draw a card, return -1;
        else {
            return -1;
        }
    }

    // get a random card from the valid options to play
    private int randomChooseCardToPlay(List<Integer> integerList) {
        Random random = new Random();
        return integerList.get(random.nextInt(integerList.size() - 1));
    }


    private int FindCardByUsingAListInteger(List<Integer> integerList, List<Card> robotCards) {
        for (Integer integer : integerList) {
            if (robotCards.get(integer).getActions().equals(Actions.REVERSE) ||
                    robotCards.get(integer).getActions().equals(Actions.SKIP_TURN)) {
                return integer;
            }
        }
        return -1;
    }

    //Check if my opponent said UNO
    private int LastMovement(Card lastCard, List<Card> robotCards) {
        //if(game.UNO && (robotCards.size() != 1)) // and I have more than two that are not especial{
        //Check if I have a +4
        if (checkForCardValue(robotCards, "+4")) {
            //If I have it then I want to use it
            return FindIndexCardByValue(robotCards, "+4");
        } else if (checkForCardValue(robotCards, "+2")) {
            //Check if I have a +2 of the same color
            var index = FindIndexCardByValue(robotCards, "+2");
            if (robotCards.get(index).getColor().equals(lastCard.getColor())) {
                return index;
            } else {
                return -1;
            }
        } else {
            return -1;
        }
    }

    private boolean checkCardsWithSameColor(String color, List<Card> robotCards) {
        boolean exists = false;
        for (Card robotCard : robotCards) {
            if (robotCard.getColor().equals(color)) {
                exists = true;
            }
        }
        return exists;
    }

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
                checkDuplicateValueCard()
                for (int j = 0; j < robotCards.size(); j++) {
                    if (robotCards.get(i).getColor().equals(robotCards.get(j).getColor())) {
                        valueCount.add(j);
                    }
                }
            }
        }
        return valueCount;
    }
// Find Card by Value


    //Check How many with the same value we have


    //check if it has wild cards
    public Boolean checkWildCard(List<Integer> integerList, List<Card> robotCards) {
        for (int x = 0; x < integerList.size(); x++) {
            if (robotCards.get(integerList.get(x)).getActions().equals(Actions.REVERSE) ||
                    robotCards.get(integerList.get(x)).getActions().equals(Actions.SKIP_TURN)) {
                return true;
            }
        }
        return false;
    }

    //Check if it has a +4 or wild to choose color
    private int getNoneColorCard(List<Card> robotCards) {
        for (Card card : robotCards) {
            if (card.getColor().equals("none")) {
                return robotCards.indexOf(card);
            }
        }
        return -1;
    }


    //Check how many cards of one color are in a deck
    private int checkQuantity(String color, List<Card> robotCards) {
        int count = 0;
        for (Card card : robotCards) {
            if (card.getColor().equals(color)) {
                return count++;
            }
        }
        return count;
    }


    //Randomly choose between playing and drawing a card
    private Boolean randomPlayOrDraw() {
        Random random = new Random();
        return random.nextBoolean();

    }

    // If opponent has UNO and I have a +4 then play plus 4
    private Boolean checkForCardValue(List<Card> cards, String value) {
        for (Card card : cards) {
            if (card.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }

    private Boolean checkDuplicateValueCard(Card lastCard, List<Card> robotCards) {
        int count = -1;
        for (int i = 0; i < robotCards.size(); i++) {
            if (robotCards.get(i).getValue().equals(lastCard.getValue()) && !robotCards.get(i).getColor().equals(lastCard.getColor())) {
                count++;
            }
        }
        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    public int FindIndexCardByValue(List<Card> cards, String value) {
        for (int x = 0; x < cards.size(); x++) {
            if (cards.get(x).getValue().equals(value)) {
                return x;
            }
        }
        return 0;
    }


}


