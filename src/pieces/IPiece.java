package pieces;

import game.Board;

public interface IPiece {
	
	public abstract Board threatenedSquares(Board board);
	public abstract void setMovement();
	
}
