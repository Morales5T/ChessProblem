package pieces;

import game.Square;

/**
 * 
 * @author Luis
 *
 * King implementation
 */
public class King extends Piece{
	
	public King(final int x, final int y) {
		super(x, y);
		this.setMovement();
	}
	
	public King() {
		super();
		this.setMovement();
	}
	
	@Override
	public Square getType() {
		return Square.KING;
	}

}
