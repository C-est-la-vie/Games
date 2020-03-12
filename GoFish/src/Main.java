import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] arg) {
        Boolean state = true;
        Game game = new Game();
        game.startGame();
        Messages messages = new Messages();
        Scanner input = new Scanner(System.in);
        String answer;

        //Let's make a pause at the beginning so the person can see it's cards.
        //THen they can click OK to keep going if it is the computer's turn
        // THe instructions should show at the beggining.
        //It doesn't like my pattern.
        //From 2 - 8.
        //1, 9 10 workd

        do{
            messages.welcomeMessage();
             answer = input.next().toUpperCase();
            if (answer.equals("S")){
                game.play();
                state = false;
            }else if(answer.equals("I")){
                messages.instructions();
            }
        }while (state);

    }
}