package pieces;

import java.awt.Point;

import game.Board;
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
	public Board threatenedSquares(Board board) {
		
		Board boardAux = board.clone();
		
		//Check position where the piece is going to be placed
		if(boardAux.isFree(super.getY(), super.getX())){
			
			//Place the piece
			boardAux.setSquare(this.point.y, this.point.x, Square.KNIGHT);
			
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
			
			return boardAux;			
		}
		else{
			return null;
		}
	}
	
	@Override
	public Square getType() {
		return Square.KING;
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
