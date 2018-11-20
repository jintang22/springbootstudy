package examples.spring.di;

public class Dice {

    private int face;

    public Dice(int face) {
        System.out.println("Dice");
        this.face = face;
    }

    public int getNumber(){
        return (int)(this.face * Math.random()) +1;
    }
}
