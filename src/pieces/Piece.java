package pieces;

public abstract class Piece implements IPiece{
	
	private int x;
	private int y;
	int [][][] movement;
	
	public Piece (){}
	
	public Piece (final int x, final int y){
		this.setX(x);
		this.setY(y);
		this.movement = new int[3][3][2];
	}
	
	protected void setX(final int x){
		this.x = x;
	}
	
	protected int getX(){
		return this.x;
	}
	
	protected void setY(final int y){
		this.y = y;
	}
	
	protected int getY(){
		return this.y;
	}

}
