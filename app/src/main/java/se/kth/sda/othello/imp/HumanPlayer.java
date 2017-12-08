package se.kth.sda.othello.imp;

import java.util.List;

import se.kth.sda.othello.board.Node;
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

    //start: new method by Aleksandar 12.07
    //Right now we are not using this method for a Human Player
    //But it can be used later as Help feature is added
    @Override
    public String pickMove(List<Node> possibleMoves) {
        return null;
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

    /**
     * @author Aleksandar
     */
    @Override
    public int getScore() {
        return this.score;
    }

    /**
     * @author Aleksandar
     */
    @Override
    public void setScore(int score) {
        this.score = score;
    }
}
