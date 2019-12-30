
public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot();
        Game game = new Game(robot);
        Rules rule = new Rules(game);
        game.setRule(rule);
        robot.setGame(game);
        game.WelcomeMessage();
        game.Menu();

    }
}

