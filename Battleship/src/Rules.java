public class Rules {
    /**
     * x can't be less than 0 or greater than 4 and y can't be less than 0 or greater than 4
     */
    public Boolean checkeValidateCoordinate(int x, int y) {
        if (x > 4 || x < 0) {
            System.out.println(x + " is not a validate option");
            return false;
        } else if (y > 4 || y < 0) {
            System.out.println(y + " is not a validate option");
            return false;
        } else {
            return true;
        }
    }

    /**
     * x && y shouldn't have already been used.
     */
    public Boolean checkUsedCoordinates(int x, int y, String[][] board) {
        if (board[y][x].equals("X")) {
            System.out.println("Opps! That's not a validate pair of coordinates any more");
            return false;
        } else {
            return true;
        }
    }

    /**
     * if x and y == where the ship is a message should let the player know
     */
    public Boolean checkAgainstHidedShip(int x, int y, int[][] ships) {
        for (int[] ship : ships) {
            if (ship[0] == y && ship[1] == x) {
                System.out.println("You got one!");
                return true;
            }
        }
        System.out.println("Maybe next time...");
        return false;
    }

}
