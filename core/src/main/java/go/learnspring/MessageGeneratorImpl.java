package go.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    @Autowired
    private Game game;

    private int guessCount = 10;

    @PostConstruct
    public void init() {
        log.info("game: {}", game);
    }



    @Override
    public String getMainMessage() {
        log.debug("getMainMessage");
        return "getMainMessage called";
    }

    @Override
    public String getResultMessage() {
        log.debug("getResultMessage");
        return "getResultMessage called";
    }
}
