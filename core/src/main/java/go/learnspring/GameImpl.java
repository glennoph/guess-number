package go.learnspring;

import go.learnspring.config.AppConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class GameImpl implements Game {

    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    @Autowired
    private NumberGenerator numberGenerator;

    @Autowired
    private AppConfig appConfig;

    private int number;
    private int guess;
    private int smallest;
    private int largest;
    private int remainingGuesses;
    private boolean validNumberRange = true;


    @PostConstruct
    @Override
    public void reset() {
        log.info("reset - postConstruct");
        smallest = 0;
        guess = 0;
        remainingGuesses = getGuessCount();
        largest = getMaxNumber();
        number = numberGenerator.next();
        log.debug("number: {}", number);
    }

    @PreDestroy
    public void preDestroy() {
        log.info("preDestroy");
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public int getGuess() {
        return guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return smallest;
    }

    @Override
    public int getLargest() {
        return largest;
    }

    @Override
    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    @Override
    public int getGuessCount() {
        return appConfig.getGuessCount();
    }

    @Override
    public int getMaxNumber() {
        return appConfig.getMaxNumber();
    }

    @Override
    public void check() {
        checkValidNumberRange();

        if (validNumberRange) {
            if (guess > number) {
                largest = guess - 1;
            }
            if (guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--; // decr
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest)
                && (guess <= largest);
    }

}
