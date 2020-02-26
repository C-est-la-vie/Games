import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Rules rule = new Rules();
        Scanner input = new Scanner(System.in);
        Ships ships = new Ships();
        int count = 0;

        int turn = 0;
        while (turn < 5 && count < 3) {
            board.displayBoard();
            System.out.println("Enter some coordinates for x: ");
            int x = input.nextInt();
            System.out.println("Enter some coordinates for y: ");
            int y = input.nextInt();
            if (rule.checkeValidateCoordinate(x, y)) {
                if (rule.checkUsedCoordinates(x, y, board.getBoard())) {
                    board.changeBoardCoordinate(y, x);
                    board.displayBoard();
                    if (rule.checkAgainstHidedShip(x, y, ships.getShips())) {
                        count++;
                    }
                }
            }

            turn++;
        }
        if (count == 3) {
            System.out.println("You won!!");
        } else {
            System.out.println("You were so close!! Better luck next time");
        }
        System.out.println("Thank you for playing");
    }
}
