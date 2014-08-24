package game;
	
/**
 * @author Luis
 *
 * Possible states of one square
 */
public enum Square{
	FREE("-"), 
	THREATED("-"),
	KING("K"),
	QUEEN("Q"),
	BISHOP("B"),
	ROOK("R"),
	KNIGHT("N"); 
			
	private final String square;
			
	private Square(final String square){
		this.square = square;
	}
			
	@Override
	public String toString(){
		return this.square;
	}
}
	

