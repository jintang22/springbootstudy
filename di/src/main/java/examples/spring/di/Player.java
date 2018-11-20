package examples.spring.di;

public class Player {
    private String name;
    private Dice dice;

    public Player(String name , Dice dice) {
        System.out.println("Player");
        this.name = name;
        this.dice = dice;
    }

    public int play(){
        return dice.getNumber();
    }

    public void roll() {
        System.out.println(this.name + " roll. and number is " + this.dice.getNumber());
    }
}
