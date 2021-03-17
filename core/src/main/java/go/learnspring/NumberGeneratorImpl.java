package go.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class NumberGeneratorImpl implements NumberGenerator {

    private static final Logger log = LoggerFactory.getLogger(NumberGeneratorImpl.class);

    private final Random random = new Random();

    private int maxNumber = 50;

    @Override
    public int next() {
        int nextNum = random.nextInt(maxNumber);
        log.debug(String.valueOf(nextNum));
        return nextNum;
    }

    @Override
    public int getMaxNumber() {
        log.debug(String.valueOf(maxNumber));
        return maxNumber;
    }
}
