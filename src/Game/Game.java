package Game;

public interface Game {
    void start(Integer sizeWord, Integer maxTry);
    Answer inputValue(String value);

    GameStatus getGameStatus();

    LogClass getLogClass();
}