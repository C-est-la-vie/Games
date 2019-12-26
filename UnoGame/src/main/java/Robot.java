public class Robot extends Player {
    //check the rulecolor
    public int checkRuleColor(Game game, Robot robot) {
        Card card = game.getLastCard();
        // counter. Count how many cards of that color you have.
        int colorCount = 0;
        for (int i = 0; i < robot.getCards().size(); i++) {
            if (robot.getCards().get(i).getColor().equals(card.getColor())) {
                colorCount++;
            }
        }
        return colorCount;

    }
    //check the value
    //check if he has a card with the value
    public int checkRuleValue(Game game, Robot robot) {
        Card card = game.getLastCard();
        int valueCount = 0;
        for (int i = 0; i < robot.getCards().size(); i++) {
            if (robot.getCards().get(i).getValue().equals(card.getValue())) {
                for (int j = 0; j < robot.getCards().size(); j++) {
                    if (robot.getCards().get(i).getColor().equals(robot.getCards().get(j).getColor())) {
                        valueCount++;
                    }
                }
            }
        }
        return valueCount;
    }

    //

    //robot will choose the card with the more colors
    public void chooseMoreColor(Game game, Robot robot) {
        int colorCount = robot.checkRuleColor(game, robot);
        int valueCount = robot.checkRuleColor(game, robot);
        if (colorCount > valueCount) {

        }


    }
    //special card: if robot has it, choose that color of special card

    //if robot doesn't have any valid colors, and have special cards, then choose option randomly (including draw 1)
}
