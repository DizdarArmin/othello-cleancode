package se.kth.sda.othello.imp;


import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import static org.junit.Assert.*;

import se.kth.sda.othello.Othello;

import se.kth.sda.othello.OthelloFactory;

import se.kth.sda.othello.board.Board;

import se.kth.sda.othello.board.Node;


/**

 * Created by Aleksandar on 11/27/2017.

 */


public class PossibleMovesTest {

    Othello game;

    OthelloFactory gameFactory = new OthelloFactoryImp();

    Board board;


    public PossibleMovesTest() {

        this.game = gameFactory.createHumanGame();

        this.game.start();

        this.board = game.getBoard();

        setTestBoard();

    }

    /**
     * Manually sets the board. Needed for further testing
     */
    public void setTestBoard() {

       /*game.setNode(new NodeImp("2,3","P1"));

       game.setNode(new NodeImp("2,5","P1"));

       game.setNode(new NodeImp("3,2","P2"));

       game.setNode(new NodeImp("3,3","P2"));

       game.setNode(new NodeImp("3,4","P1"));

       game.setNode(new NodeImp("3,5","P1"));

       game.setNode(new NodeImp("4,3","P1"));

       game.setNode(new NodeImp("4,4","P2"));

       game.setNode(new NodeImp("4,5","P1"));

       game.setNode(new NodeImp("5,5","P2"));

       game.setNode(new NodeImp("3,3","P2"));

       game.setNode(new NodeImp("3,4","P1"));

       game.setNode(new NodeImp("4,3","P1"));

       game.setNode(new NodeImp("4,4","P2"));*/

    }


    /**
     * Author: Maksim Melnik
     * Checks that GetPossibleMoves works correctly by manually setting the board
     */
    @Test
    public void callGetPossibleMoves() {

        game.setNode(new NodeImp("3,3","P2"));

        game.setNode(new NodeImp("3,4","P1"));

        game.setNode(new NodeImp("4,3","P1"));

        game.setNode(new NodeImp("4,4","P2"));

        String[] expectedMoves = {"2,3","4,5","3,2","5,4"};
        Arrays.sort(expectedMoves);

        List<Node> actualPossibleMoves = game.getPossibleMoves();
        List<String> stringList = new Vector<>();
        for(Node node:actualPossibleMoves) {

            stringList.add(node.getId());

        }

        Object[] objectList = stringList.toArray();
        String[] actualMoves = Arrays.copyOf(objectList, objectList.length, String[].class);
        Arrays.sort(actualMoves);
        assertArrayEquals(expectedMoves, actualMoves);
    }

    public void callgetNodesToSwap() {

        List<Node> testList = game.getNodesToSwap("P1","2,3");

        for(Node node:testList) {

            System.out.println(node.getId());

        }

    }








}