package se.kth.sda.othello.imp;



import org.junit.Test;



import java.util.ArrayList;

import java.util.List;

import java.util.Vector;



import se.kth.sda.othello.board.Node;



import static org.junit.Assert.*;



/**

 * Author: Maksim Melnik

 */

public class BoardImpTest {


    /**
     * Checks that 8 x 8 board actually has 64 nodes
     */

    @Test

    public void getNodes() throws Exception {

        Node nodes[][] = new Node[8][8];

        List<Node> res = new Vector<Node>();

        for (int i = 0; i < 8; i++) {

            for (int j = 0; j < 8; j++) {

                res.add(nodes[i][j]);

            }

        }

        assertTrue(res.size() == 64);

    }
}