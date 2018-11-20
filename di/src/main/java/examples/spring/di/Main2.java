package examples.spring.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main2 {

    public static void main(String[] args){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(DiceGameConfig.class);

        Game game = applicationContext.getBean(Game.class);

        game.play();

    }
}
