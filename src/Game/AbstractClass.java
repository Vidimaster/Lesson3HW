package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class AbstractClass implements Game {
    Integer sizeWord;
    Integer maxTry;

    String computerWord;

    GameStatus gameStatus = GameStatus.INIT;


    LogClass logClass = new LogClass();

    public AbstractClass() {
        super();
    }

    abstract ArrayList<String> generateCharList();

    @Override
    public void start(Integer sizeWord, Integer maxTry) {
        this.sizeWord = sizeWord;
        this.maxTry = maxTry;
        computerWord = generateWord();
        gameStatus = GameStatus.START;

        logClass.LogAdd("Game Started");
        System.out.println("Game started, guess the word " + "(" + sizeWord + ")" + " letters");
        logClass.LogAdd("Computer generated word: " + computerWord);

    }

    private String generateWord() {
        List<String> alphabet = generateCharList();
        Random random = new Random();
        String res = "";
        for (int i = 0; i < sizeWord; i++) {
            int randomIndex = random.nextInt(alphabet.size());
            res += alphabet.get(randomIndex);
            alphabet.remove(randomIndex);
        }

        return res;
    }

    @Override
    public Answer inputValue(String value) {
        int bull = 0;
        int cow = 0;
        if (sizeWord < value.length()){value = value.substring(0, sizeWord);}
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == computerWord.charAt(i)) {
                bull++;

            }
            if (computerWord.contains(String.valueOf(value.charAt(i)))) {
                cow++;
            }
        }
        logClass.LogAdd("Player Entered Word: " + value + " bulls: " + bull + " cows: " + cow);
        maxTry--;
        if (maxTry == 0 && gameStatus != GameStatus.WIN) {
            gameStatus = GameStatus.LOSE;
            System.out.println("Player lost");
            logClass.LogAdd("Player lost");
        }
        if (bull == computerWord.length()) {
            gameStatus = GameStatus.WIN;
            System.out.println("Player won");
            logClass.LogAdd("Player won");
        }

        return new Answer(bull, cow, maxTry);
    }

    @Override
    public GameStatus getGameStatus() {

        return gameStatus;
    }

    @Override
    public LogClass getLogClass() {
        return logClass;
    }
}
