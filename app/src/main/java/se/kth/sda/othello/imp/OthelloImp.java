package se.kth.sda.othello.imp;

import android.widget.Toast;

import java.util.List;
import java.util.Vector;

import se.kth.sda.othello.Othello;
import se.kth.sda.othello.board.Board;
import se.kth.sda.othello.board.Node;
import se.kth.sda.othello.player.Player;

/**
 * Created by robertog on 2/7/17.
 */
public class OthelloImp implements Othello {
    private final Player playerOne;
    private final Player playerTwo;
    private final BoardImp board;
    private Player currentPlayer;
    List<Node> nodeRes ;

    public OthelloImp(Player one, Player two) {
        this.playerOne = one;
        this.playerTwo = two;
        this.board = new BoardImp();
        nodeRes = new Vector<Node>();
    }

    @Override
    public Board getBoard() {
        return board;
    }

    @Override
    public List<Node> getNodesToSwap(String playerId, String nodeId) {
        return new Vector<Node>();
    }

    @Override
    public Player getPlayerInTurn() {
        return this.currentPlayer;
    }

    @Override
    public List<Player> getPlayers() {
        List<Player> res = new Vector<Player>();
        res.add(playerOne);
        res.add(playerTwo);
        return res;
    }

    @Override
    public boolean hasValidMove(String playerId) {
        return true;
    }

    @Override
    public boolean isActive() {
        return true;
    }

    @Override
    public boolean isMoveValid(String playerId, String nodeId) {

        for(Node node:nodeRes){
            if(node.getId().equals(nodeId)){
                return false;
            }
        }

        return true;
    }

    private void swapPlayer() {
        if (currentPlayer == playerOne)
            currentPlayer = playerTwo;
        else
            currentPlayer = playerOne;
    }

    @Override
    public List<Node> move() {
        if (currentPlayer.getType() != Player.Type.COMPUTER)
            throw new IllegalStateException("Current player is not a computer");

        swapPlayer();

        return new Vector<Node>();
    }

    @Override
    public List<Node> move(String playerId, String nodeId) throws IllegalStateException {
        if (currentPlayer.getType() != Player.Type.HUMAN)
            throw new IllegalStateException("Current player is not a human");
        if (! isMoveValid(playerId, nodeId))
            throw new IllegalStateException("Invalid move");
        if (playerId != currentPlayer.getId())
            throw new IllegalStateException("Invalid player ID");

        Node newNode = new NodeImp(nodeId, playerId);
        board.setNode(newNode);
        nodeRes.add(newNode);

        swapPlayer();

        return nodeRes;
    }

    @Override
    public void start() {
        // TODO: choose a random player
        currentPlayer = playerOne;
    }

    @Override
    public void start(String playerId) {
        // TODO: choose the player with the right ID
        currentPlayer = playerOne;
    }

    /**
     * Get the score of the current player by Xin
     * @param playerId current player
     * @return the score of the current player
     */
    public int getPlayerScore(String playerId){
        int score =0;

        for(Node node: nodeRes){
            if(playerId.equals(node.getOccupantPlayerId())){

                score++;
            }
        }
        return score;
    }
}
