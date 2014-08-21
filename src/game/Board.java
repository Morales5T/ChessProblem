package game;

public class Board {
	
	private Square[][] board;
	private int limitX;
	private int limitY;
	
	public Board(final Square[][] board){
		this.setBoard(board);
		this.setLimitX(this.getBoard()[0].length);
		this.setLimitY(this.getBoard().length);
		this.initBoard();
	}
	
	public boolean isInsideBoard(final int y, final int x){				
		return (x >= 0 && x < this.getLimitX()) && (y>=0 && y < this.limitY);
	}
	
	public boolean isValid(final int y, final int x){			
		return this.getBoard()[y][x].equals(Square.FREE) || this.getBoard()[y][x].equals(Square.THREATED);
	}
	
	public boolean isFree(final int y, final int x){			
		return this.getBoard()[y][x].equals(Square.FREE);
	}
	
	private void initBoard(){		
		
		for(int i=0; i< this.getLimitY(); i++){
			for(int j=0; j<this.getLimitX(); j++){
				this.setSquare(i, j, Square.FREE);
			}
		}
		
	}
	
	public void printBoard(){
		
		for(int i=0; i< this.getLimitY(); i++){
			for(int j=0; j<this.getLimitX(); j++){
				System.out.print(this.getSquare(i, j) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	public void setSquare(final int y, final int x, final Square square){
		this.board[y][x] = square;
	}
	
	public Square getSquare(final int y, final int x){
		return this.board[y][x];
	}
	
	public void setBoard(final Square[][] board){
		this.board = board;
	}
	
	public Square[][] getBoard(){
		return this.board;
	}
	
	public void setLimitX(final int limitX){
		this.limitX = limitX;
	}
	
	public int getLimitX(){
		return this.limitX;
	}
	
	public void setLimitY(final int limitY){
		this.limitY = limitY;
	}
	
	public int getLimitY(){
		return this.limitY;
	}

}
