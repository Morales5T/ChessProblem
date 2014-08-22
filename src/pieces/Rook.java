package pieces;

import java.awt.Point;

import game.Square;

public class Rook extends Piece{
	
	public Rook(final int x, final int y) {
		super(x, y);
		this.setMovement();
	}
	
	public Rook() {
		super();
		this.setMovement();
	}
	
	public Square getType(){
		return Square.ROOK;
	}

	@Override
	public void setMovement() { 

		super.movement.add(new Point(-1,0));
		super.movement.add(new Point(0,-1));
		super.movement.add(new Point(0,1));
		super.movement.add(new Point(1,0));
		
	}

}
