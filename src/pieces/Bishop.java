package pieces;

import java.awt.Point;

import game.Square;

public class Bishop extends Piece{
	
	public Bishop(final int x, final int y) {
		super(x, y);
		this.setMovement();
	}
	
	public Bishop() {
		super();
		this.setMovement();
	}
	
	public Square getType(){
		return Square.BISHOP;
	}

	@Override
	public void setMovement() {

		super.movement.add(new Point(-1,1));
		super.movement.add(new Point(-1,-1));
		super.movement.add(new Point(1,-1));
		super.movement.add(new Point(1,1));
					
	}

}
