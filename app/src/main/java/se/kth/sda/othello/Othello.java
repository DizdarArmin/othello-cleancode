package se.kth.sda.othello;

import java.util.List;

import se.kth.sda.othello.board.Board;
import se.kth.sda.othello.board.Node;
import se.kth.sda.othello.player.Player;

/**
 * This class represents an Othello game.
 *
 * @author Tomas Ekholm
 */
public interface Othello {

	/**
	 * The board on which the game is played.
	 *
	 * @return the state of the board
	 */
	public Board getBoard();

	/**
	 * Sets a node to different properties in the Board  .
	 *
	 * @param node the node to set
     * @author Aleksandar
	 */
	public void setNode(Node node);

	/**
	 * Returns the nodes that will be swapped for a move at the given nodeId.
	 *
	 * @param playerId the id of the player making the move
	 * @param nodeId the id of the node where the move is made
	 * @return the list of nodes that will be swapped for the given move
     * @author Aleksandar
	 */
	public List<Node> getNodesToSwap(String playerId, String nodeId);

	/**
	 * Returns the nodes as next possible moves  .
	 *
	 * @return the list of nodes as possible moves for the next move
     * @author Aleksandar
	 */
	public List<Node> getPossibleMoves();

	/**
	 * Get the player in turn or null if no player can move
	 *
	 * @return the player in turn
	 */
	public Player getPlayerInTurn();

	/**
	 * The players of the game. Computer players as well as human players.
	 *
	 * @return the list of players
	 */
	public List<Player> getPlayers();

	/**
	 * Determines if a player has any valid move.
	 *
	 * @param playerId the id of the player
	 * @return true if the player has a valid move
     * @author Aleksandar
	 */
	public boolean hasValidMove(String playerId);

	/**
	 * Determines if the game is active or over
	 *
	 * @return false if the game is over
     * @author Aleksandar
	 */
	public boolean isActive();

	/**
	 * Determines if a player is allowed to make a move at the given node.
	 *
	 * @param playerId the id of the player making the move
	 * @param nodeId the node id where the player wants to play
	 * @return true if the move is valid
     * @author Aleksandar
	 */
	public boolean isMoveValid(String playerId, String nodeId);

	/**
	 * If the player in turn is a computer than this computer makes a move and updates the player in turn. 
	 *
	 * @return the nodes that where swapped for this move, including the node where the player made the move
	 * @throws IllegalStateException if there is not a computer in turn
	 */
	public List<Node> move();

	/**
	 * Validates if the move is correct and if the player is in turn. If so, then the move is made which updates the
	 * board and the player in turn. 
	 *
	 * @param playerId the id of the player that makes the move
	 * @param nodeId the id of the node where the player wants to move
	 * @return the nodes that where swapped for this move, including the node where the player made the move
	 * @throws IllegalArgumentException if the move is not valid, or if the player is not in turn
	 */
	public List<Node> move(String playerId, String nodeId) throws IllegalArgumentException;

	/**
	 * Starts the game. The player in turn will be chosen randomly.
	 */
	public void start();

	/**
	 * Starts the game.
	 *
	 * @param playerId the id of the player that will start the game.
	 */
	public void start(String playerId);

	/**
	 * Get the score of the current player
     *
	 * @param playerId current player
	 * @return the score of the current player
     * @author Xin
	 */
	public int getPlayerScore(String playerId);

	/**
	 * Return a message with a score when the game ends
     *
	 * @return string message
	 * @author petrych
	 */
	public String getGameEndMessage();

    /**
     * Set initial 2 nodes for each player
     *
     * @author petrych
     */
	public void moveInitialNodes();

	/**
	 * Swap to another player.
	 */
	public void swapPlayer();
}
