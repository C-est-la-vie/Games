
public class Board {
    private String[][] board = new String[5][5];

    Board() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                this.board[i][j] = "O";
            }
        }
    }

    public void displayBoard() {
        System.out.println("   0 1 2 3 4 ");
        System.out.println("  ----------");
        for (int i = 0; i < board.length; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public void changeBoardCoordinate(int i, int j) {
        board[i][j] = "X";
    }

    public String[][] getBoard() {
        return board;
    }
}