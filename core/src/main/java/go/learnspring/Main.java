package go.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private static final String CONFIG_LOCATION = "beans.xml";

    public static void main(String[] args) {
        log.info("guess the number game");

        // create context container
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext(CONFIG_LOCATION);

        log.info("get bean numberGenerator");
        // get bean from container
        NumberGenerator numberGenerator =
                context.getBean(NumberGenerator.class);

        // get random number
        int number = numberGenerator.next();

        Game game = context.getBean(Game.class);

        game.reset();


        // close container
        log.info("context.close()");
        context.close();

    }
}
