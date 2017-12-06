package se.kth.sda.othello.imp;

import se.kth.sda.othello.player.Player;

/**
 * Created by alexo1979 on 12/5/17.
 *
 * A class for a Computer player
 */

public class ComputerPlayer implements Player {
    private final String id;
    private final String name;

    private int score;

    public ComputerPlayer(String id, String name) {
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
        return Type.COMPUTER;
    }

    //start: new method by Aleksandar 12.05
    @Override
    public int getScore() {
        return this.score;
    }

    //start: new method by Aleksandar 12.05
    @Override
    public void setScore(int score) {
        this.score = score;
    }
}
