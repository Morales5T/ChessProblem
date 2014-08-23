package pieces;

import game.Board;
import game.Square;

/**
 * 
 * @author Luis
 *
 * Interface for the pieces
 */
public interface IPiece {
	
	/**
	 * Calculates all the possible movements of one piece. If this piece
	 * does not threaten other pieces the function returns the board
	 * with the piece in it and all the threatened squares.
	 * Otherwise if the piece threatens other pieces the function return null.
	 * 
	 * @param board
	 * @return the new board with the piece and the threatened squares or null.
	 */
	abstract Board threatenedSquares(Board board);
	
	/**
	 * Sets the list with the possible movements of the piece
	 */
	abstract void setMovement();

	void setX(final int x);	
	void setY(final int y);	

	Square getType();
	
}
