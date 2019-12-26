public class Robot extends Player {
    //check the rulecolor
    public void checkRuleColor(Game game, Robot robot) {
        Card card = game.getRuleCard();
        // counter. Count how many cards of that color you have.
        int count = 0;
        for (int i = 0; i < robot.getCards().size(); i++) {
            if (robot.getCards().get(i).getColor().equals(card.getColor())) {
                count++;
            }
        }

    }
    //check the value
    //check if he has a card with the value
    public void checkRuleValue(Game game, Robot robot) {
        Card card = game.getRuleCard();
        int count = 0;
        for (int i = 0; i < robot.getCards().size(); i++) {
            if (robot.getCards().get(i).getValue().equals(card.getValue())) {
                for (int j = 0; j < robot.getCards().size(); j++) {
                    if (robot.getCards().get(i).getColor().equals(robot.getCards().get(j).getColor())) {
                        count++;
                    }
                }
            }
        }
    }

    //robot will choose the card with the more colors

    //special card: if robot has it, choose that color of special card

    //if robot doesn't have any valid colors, and have special cards, then choose option randomly (including draw 1)
}
