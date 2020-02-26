import java.util.Random;

public class Ships {
    private int[][] ships = new int[3][2];

    Ships() {
        Random random = new Random();

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                int num = random.nextInt(4) + 1;
                ships[i][j] = num;
                System.out.println("value of i: " + i + " value of j: " + j + "value of num: " + num);
            }
        }
    }

    public int[][] getShips() {
        return ships;
    }
}
