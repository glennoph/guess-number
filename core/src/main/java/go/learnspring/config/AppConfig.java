package go.learnspring.config;

import go.learnspring.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "go.learnspring")
@PropertySource("classpath:game.properties")
public class AppConfig {

    @Value("${game.maxNumber}")
    private int maxNumber;

    @Value("${game.guessCount}")
    private int guessCount;

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getGuessCount() {
        return guessCount;
    }


    // bean methods
    @Bean
    public NumberGenerator numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public Game game() {
        return new GameImpl();
    }

    @Bean
    public MessageGenerator messageGenerator() {
        return new MessageGeneratorImpl();
    }



}

