package pieces;

import game.Board;
import game.Square;

public interface IPiece {
	
	abstract Board threatenedSquares(Board board);
	abstract void setMovement();

	void setX(final int x);	
	int getX();	
	void setY(final int y);	
	int getY();
	Square getType();
	
}
