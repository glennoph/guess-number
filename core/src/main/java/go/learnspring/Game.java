package go.learnspring;

public interface Game {
    int getNumber();

    int getGuess();

    void setGuess(int guess);

    int getSmallest();

    int getLargest();

    int getRemainingGuesses();

    int getGuessCount();

    int getMaxNumber();

    void reset();

    void check();

    boolean isValidNumberRange();
    boolean isGameWon();
    boolean isGameLost();

}
