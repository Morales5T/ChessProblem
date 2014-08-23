package pieces;

import game.Square;

/**
 * 
 * @author Luis
 *
 * Queen implementation
 */
public class Queen extends Piece{
	
	public Queen(final int x, final int y) {
		super(x, y);
		this.setMovement();
	}
	
	public Queen() {
		super();
		this.setMovement();
	}
	
	public Square getType(){
		return Square.QUEEN;
	}

}
