package game;

/**
 * 
 * @author Luis
 *
 */
public class Board implements Cloneable{
	
	private Square[][] squares;
	
	public Board(final Square[][] squares){
		this.squares = squares;
		this.initBoard();
	}
	
	/**
	 * Checks if the position is inside the board
	 * 
	 * @param y position y
	 * @param x position x
	 * @return boolean 
	 */
	public boolean isInsideBoard(final int y, final int x){				
		return (x >= 0 && x < this.squares[0].length) && (y>=0 && y < this.squares.length);
	}
	
	/**
	 * Checks if the position is not free or threatened
	 * 
	 * @param y position y
	 * @param x position x
	 * @return boolean 
	 */
	public boolean isValid(final int y, final int x){			
		return this.squares[y][x].equals(Square.FREE) || this.squares[y][x].equals(Square.THREATED);
	}
	
	/**
	 * Checks if the position is free
	 * 
	 * @param y position y
	 * @param x position x
	 * @return boolean 
	 */
	public boolean isFree(final int y, final int x){			
		return this.squares[y][x].equals(Square.FREE);
	}
	
	/**
	 * Initializes the board
	 */
	private void initBoard(){		
		
		for(int i=0; i< this.squares.length; i++){
			for(int j=0; j< this.squares[0].length; j++){
				this.squares[i][j] = Square.FREE;
			}
		}
		
	}
	
	/**
	 * Prints the board
	 */
	public void printBoard(){
		
		for(int i=0; i< this.squares.length; i++){
			for(int j=0; j< this.squares[0].length; j++){
				System.out.print(this.getSquare(i, j) + " ");
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	public Board clone(){
		Board boardClone = new Board(new Square[this.squares.length][this.squares[0].length]);
		
		for(int i=0; i< this.squares.length; i++){
			for(int j=0; j< this.squares[0].length; j++){
				boardClone.squares[i][j] = this.squares[i][j];
			}
		}
		
		return boardClone;
	}
	
	/* Getters and Setters */
	
	public void setSquare(final int y, final int x, final Square square){
		this.squares[y][x] = square;
	}
	
	public Square getSquare(final int y, final int x){
		return this.squares[y][x];
	}
	
	public void setSquares(final Square[][] squares){
		this.squares = squares;
	}
	
	public Square[][] getSquares(){
		return this.squares;
	}

}
