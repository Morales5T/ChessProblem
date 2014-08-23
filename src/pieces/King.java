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
		
		if(board.isFree(super.getY(), super.getX())){
			
			board.getSquares()[super.getY()][super.getX()] = Square.KING;
			
			int posX;
			int posY;
			Point point;
			
			for(int i=0; i<this.movement.size(); i++){
				point = this.movement.get(i);
				posX = point.x + super.point.x;
				posY = point.y + super.point.y;
				if(board.isInsideBoard(posY, posX)){
					if(board.isValid(posY, posX)){
						board.getSquares()[posY][posX] = Square.THREATED;
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
		
		return board;
	}
	
	@Override
	public Square getType() {
		return Square.KING;
	}

}
