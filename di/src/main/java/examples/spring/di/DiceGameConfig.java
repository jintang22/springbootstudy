package examples.spring.di;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DiceGameConfig {

    @Bean
    public Dice dice(){
        System.out.println(this.getClass().getName());
        return new Dice(6);
    }

    @Bean
    public Player kim(){
        return new Player("kim", dice());
    }

    @Bean
    public Player lee(){
        return new Player("lee", dice());
    }

    @Bean
    public Player hong(){
        return new Player("hong", dice());
    }

    @Bean
    public Game game(){
        Game game = new Game();
        List<Player> playerList = new ArrayList<>();
        playerList.add(kim());
        playerList.add(lee());
        playerList.add(hong());
        game.setPlayerList(playerList);
        return game;
    }
}
