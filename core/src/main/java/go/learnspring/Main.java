package go.learnspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        log.info("guess the number game");

        // create context container
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        log.info("get bean numberGenerator");
        // get bean from container
        NumberGenerator numberGenerator =
                context.getBean(NumberGenerator.class);

        // get random number
        int number = numberGenerator.next();

        // get message generator bean
        MessageGenerator messageGenerator =
                context.getBean(MessageGenerator.class);

        // get main message
        log.info("getMainMessage: {}", messageGenerator.getMainMessage());
        log.info("getResultMessage: {}", messageGenerator.getResultMessage());


        // close container
        log.info("context.close()");
        context.close();

    }
}
