package se.kth.sda.othello.imp;

import se.kth.sda.othello.player.Player;

/**
 * Created by robertog on 2/7/17.
 */
public class HumanPlayer implements Player {
    private final String id;
    private final String name;

    private int score;

    public HumanPlayer(String id, String name) {
        this.id = id;
        this.name = name;

        //the starting score
        this.score = 2;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Type getType() {
        return Type.HUMAN;
    }

    //start: new method by Aleksandar 12.01
    @Override
    public int getScore() {
        return this.score;
    }

    //start: new method by Aleksandar 12.01
    @Override
    public void setScore(int score) {
        this.score = score;
    }
}
