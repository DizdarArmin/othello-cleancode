package se.kth.sda.othello.player;

import java.util.List;

import se.kth.sda.othello.board.Node;

/**
 * A representation of player.
 *
 * @author Tomas Ekholm
 */
public interface Player {

	//start: new method by Aleksandar 12.07
	/**
	 * Used in ComputerPlayer to get the next computer move
	 * from a list of possible moves
	 *
	 * @return the nodeID of the best next move by AI strategy
	 */
	public String pickMove(List<Node> possibleMoves);

	/**
	 * The different type of {@link Player}s
	 */
	public enum Type {
		COMPUTER, HUMAN
	}

	/**
	 * The id is a unique identifier of this player in the context of all players
	 * 
	 * @return the id
	 */
	public String getId();

	/**
	 * The name of the player
	 * 
	 * @return the name
	 */
	public String getName();

	/**
	 * The {@link Type} of the player
	 * 
	 * @return the type
	 */
	public Type getType();

	//start: new method by Aleksandar 12.05
	/**
	 * Gives the score of the player
	 *
	 * @return the score of the player
	 */
	public int getScore();

	//start: new method by Aleksandar 12.05
	/**
	 * Sets the score of the player
	 *
	 * @param score the new score of the player to be set
	 */
	public void setScore(int score);
}
