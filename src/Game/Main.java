package Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Game game = new EngGame();
     game.start(5, 3);
     while (game.getGameStatus() == GameStatus.START){
         Scanner scanner = new Scanner(System.in);
        Answer answer = game.inputValue(scanner.nextLine().toUpperCase() );
         System.out.println(answer);

     }

        if (game.getGameStatus() != GameStatus.START){
            System.out.println("Show Log (y/n)?");
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine().toLowerCase();
            if (line.equals("y")){
            LogClass.ShowLog();}
        }
    }

}
