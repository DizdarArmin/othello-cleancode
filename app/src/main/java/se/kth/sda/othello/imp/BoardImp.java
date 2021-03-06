package se.kth.sda.othello.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import se.kth.sda.othello.board.Board;
import se.kth.sda.othello.board.Node;

/**
 * Created by robertog on 2/7/17.
 */
public class BoardImp implements Board {
    Node nodes[][] = new Node[8][8];

    ArrayList<Node> initialNodes = new ArrayList<>();

    public BoardImp() {
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                nodes[i][j] = new NodeImp(i,j);
            }
        }
    }

    @Override
    public List<Node> getNodes() {
        List<Node> res = new Vector<Node>();
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                res.add(nodes[i][j]);
            }
        }
        return res;
    }

    public void setNode(Node node) {
        int x = node.getXCoordinate();
        int y = node.getYCoordinate();
        nodes[x][y] = node;
    }

    //start: new method by Aleksandar 11.25
    @Override
    public Node[][] getBoardNodes(){
        return nodes;
    }

    /**
     * Returns a list of the 4 nodes initialized in the constructor.
     * @return the list of initial nodes
     * @author petrych
     */
    public ArrayList<Node> getInitialNodes() {
        return initialNodes;
    }
}
