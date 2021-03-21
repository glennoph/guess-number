package go.learnspring.console;

import go.learnspring.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class Main {

    public static void main(String[] args) {
        log.info("guess the number game");
        // create context container
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);


        // close container
        log.info("context.close()");
        context.close();
    }
}
