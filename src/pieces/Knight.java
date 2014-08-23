package pieces;

import java.awt.Point;

import game.Square;

public class Knight extends Piece{

	public Knight(final int x, final int y) {
		super(x, y);
		this.setMovement();
	}
	
	public Knight() {
		super();
		this.setMovement();
	}
	
	@Override
	public Square getType() {
		return Square.KNIGHT;
	}

	@Override
	public void setMovement() { 	
		this.movement.add(new Point(-2,-1));
		this.movement.add(new Point(-2,1));
		this.movement.add(new Point(1,2));
		this.movement.add(new Point(-1,2));
		this.movement.add(new Point(2,1));
		this.movement.add(new Point(2,-1));
		this.movement.add(new Point(1,-2));
		this.movement.add(new Point(-1,-2));
	}

}
