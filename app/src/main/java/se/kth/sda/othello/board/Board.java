package se.kth.sda.othello.board;

import java.util.List;

/**
 * The responsibility of the board is to gather the nodes included in the game.
 * 
 * @author Tomas Ekholm
 */
public interface Board {

	/**
	 * Returns an ordered list of rows using the natural order in x- and then y-coordinate of the nodes.
	 * 
	 * @return the nodes of the board
	 */
	public List<Node> getNodes();

	/**
	 * Returns a Board only represented by nodes in a array of array.
	 *
	 * @return the nodes of the board
	 * @author Aleksandar
	 */
	public Node[][] getBoardNodes();

}
