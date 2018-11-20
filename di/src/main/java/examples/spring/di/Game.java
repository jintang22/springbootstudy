package examples.spring.di;

import java.util.List;

public class Game {

    private List<Player> playerList;

    public Game() {
        System.out.println("Game");
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public void play() {
        for (Player player: playerList) {

            player.roll();

        }
    }

}
