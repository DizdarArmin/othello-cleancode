package se.kth.sda.othello.imp;

import java.util.List;
import java.util.Vector;

import se.kth.sda.othello.board.Node;
import se.kth.sda.othello.player.Player;

/**
 * Created by alexo1979 on 12/5/17.
 *
 * A class for a Computer player
 */

public class ComputerPlayer implements Player {
    private final String id;
    private final String name;

    // The value of every node wich can help the CPU to make a logical move
    private final int nodeValues[][] = {{120, -20, 20,  5,  5, 20, -20, 120},
                                        {-20, -40, -5, -5, -5, -5, -40, -20},
                                        { 20,  -5, 15,  3,  3, 15,  -5,  20},
                                        {  5,  -5,  3,  3,  3,  3,  -5,   5},
                                        {  5,  -5,  3,  3,  3,  3,  -5,   5},
                                        { 20,  -5, 15,  3,  3, 15,  -5,  20},
                                        {-20, -40, -5, -5, -5, -5, -40, -20},
                                        {120, -20, 20,  5,  5, 20, -20, 120}};

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

    //start: new method by Aleksandar 12.07
    public int getNodeValue(int x, int y) {
        return this.nodeValues[x][y];
    }

    //start: new method by Aleksandar 12.07
    @Override
    public String pickMove (List<Node> possibleMoves) {
        if (possibleMoves.size() > 1) {
            String nodeID = possibleMoves.get(0).getId();
            int value = nodeValues[possibleMoves.get(0).getXCoordinate()][possibleMoves.get(0).getYCoordinate()];

            for (int i = 1; i < possibleMoves.size(); i++) {

                if (value < nodeValues[possibleMoves.get(i).getXCoordinate()][possibleMoves.get(i).getYCoordinate()]) {

                    value = nodeValues[possibleMoves.get(i).getXCoordinate()][possibleMoves.get(i).getYCoordinate()];
                    nodeID = possibleMoves.get(i).getId();
                }
            }
            return nodeID;
        }
        else
            return possibleMoves.get(0).getId();

    }
}
