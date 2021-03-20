package go.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    private static final Logger log = LoggerFactory.getLogger(NumberGeneratorImpl.class);

    private final Random random = new Random();

    @Autowired
    private Game game;

    @Override
    public int next() {
        int nextNum = random.nextInt(game.getMaxNumber());
        log.debug("nextNum: {}", nextNum);
        return nextNum;
    }

    public int getMaxNumber() {
        return game.getMaxNumber();
    }
}
