package pieces;

import game.Board;
import game.Square;

public abstract class Piece implements IPiece{
	
	private int x;
	private int y;
	protected int [][][] movement;
	private int limit;
	
	public Piece (){}
	
	public Piece (final int limit){
		this.limit = limit;
		this.movement = new int[3][3][2];
	}
	
	public Piece (final int x, final int y){
		this.x = x;
		this.y = y;
		this.movement = new int[3][3][2];
	}
	
	public Piece (final int x, final int y, final int limit){
		this.x = x;
		this.y = y;
		this.movement = new int[3][3][2];
		this.limit = limit;
	}
	
	public Board threatenedSquares(Board board) {
		
		if(board.isFree(this.getY(), this.getX())){
			
			board.getBoard()[this.getY()][this.getX()] = this.getType();
			
			int count = 0;
			int iter = 0;
			int posX;
			int posY;
			
			while(count < this.limit){
				iter++;
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){
						if(!((this.movement[i][j][0] == 0) && (this.movement[i][j][1] == 0))){
							posX = (this.movement[i][j][0] * iter) + this.getX();
							posY = (this.movement[i][j][1] * iter) + this.getY();
							if(board.isInsideBoard(posY, posX)){
								if(board.isValid(posY, posX)){
									board.getBoard()[posY][posX] = Square.THREATED;
								}
								else{
									return null;
								}
							}
							else{
								count++;
								this.movement[i][j][0] = 0;
								this.movement[i][j][1] = 0;
							}
						}
					}					
				}
			}
		}
		else{
			return null;
		}
		
		return board;
	}
	
	public void setX(final int x){
		this.x = x;
	}
	
	public int getX(){
		return this.x;
	}
	
	public void setY(final int y){
		this.y = y;
	}
	
	public int getY(){
		return this.y;
	}
	
	protected void setLimit(final int limit){
		this.limit = limit;
	}
	
	protected int getLimit(){
		return this.limit;
	}

}
