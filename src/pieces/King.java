package pieces;

import java.awt.Point;

import game.Board;
import game.Square;


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
	public Board threatenedSquares(Board board) {
		
		Board boardAux = board.clone();
		
		if(boardAux.isFree(super.getY(), super.getX())){
			
			boardAux.setSquare(this.point.y, this.point.x, Square.KING);
			
			int posX;
			int posY;
			Point point;
			
			for(int i=0; i<this.movement.size(); i++){
				point = this.movement.get(i);
				posX = point.x + super.point.x;
				posY = point.y + super.point.y;
				if(boardAux.isInsideBoard(posY, posX)){
					if(boardAux.isValid(posY, posX)){
						boardAux.getSquares()[posY][posX] = Square.THREATED;
					}
					else{
						return null;
					}
				}
			}
			
		}
		else{
			return null;
		}
		
		return boardAux;
	}
	
	@Override
	public Square getType() {
		return Square.KING;
	}

}
