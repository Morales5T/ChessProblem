package pieces;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import game.Board;
import game.Square;

public abstract class Piece implements IPiece{
	
	protected Point point = new Point();
	protected List<Point> movement = new ArrayList<Point>();
	
	public Piece (){}
	
	public Piece (final int x, final int y){
		this.point.x = x;
		this.point.y = y;
	}
	
	public Board threatenedSquares(final Board board) {

		if(board.isFree(this.point.y, this.point.x)){
			
			board.getSquares()[this.point.y][this.point.x] = this.getType();
			
			int iter = 0;
			int posX;
			int posY;
			Point point;
			int aux;
			
			while(!this.movement.isEmpty()){
				iter++;
				aux=0;
				while(aux < this.movement.size()){
					point = this.movement.get(aux);
					posX = (point.x * iter) + this.point.x;
					posY = (point.y * iter) + this.point.y;
					if(board.isInsideBoard(posY, posX)){
						if(board.isValid(posY, posX)){
							board.getSquares()[posY][posX] = Square.THREATED;
							aux++;
						}
						else{
							return null;
						}
					}
					else{
						this.movement.remove(point);
					}
				}
			}					
		}
		else{
			return null;
		}
		
		return board;
	}
	
	public void setMovement() { 
		
		for(int i=-1; i<2; i++){
			for(int j=-1; j<2; j++){
				this.movement.add(new Point(i,j));
			}
		}
		
		this.movement.remove(new Point(0,0));
		
	}
	
	public void setX(final int x){
		this.point.x = x;
	}
	
	public int getX(){
		return this.point.x;
	}
	
	public void setY(final int y){
		this.point.y = y;
	}
	
	public int getY(){
		return this.point.y;
	}
}
