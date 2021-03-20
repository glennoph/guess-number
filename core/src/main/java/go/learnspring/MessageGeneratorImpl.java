package go.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    @PostConstruct
    public void init() {
        log.info("game: {}", game);
    }



    @Override
    public String getMainMessage() {
        return "Number is between "
                + game.getSmallest()
                + " and "
                + game.getLargest()
                + " Guess number:"
                ;
    }

    @Override
    public String getResultMessage() {

        if (game.isGameWon())
            return "Guess is correct. Number was " + game.getNumber();
        if (game.isGameLost())
            return "Guess is not correct. Number was " + game.getNumber();
        if (!game.isValidNumberRange())
            return "Invalid number range";
        if (game.getRemainingGuesses() == game.getGuessCount())
            return "What is your first guess";
        String direction = (game.getGuess() < game.getNumber())? "Higher": "Lower";
        return direction + " ... you have " + game.getRemainingGuesses() + " guesses left";
    }
}
