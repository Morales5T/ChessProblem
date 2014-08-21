package pieces;

import game.Square;

public class Rook extends Piece{
	
	public Rook(final int limit) {
		super(limit);
		this.setMovement();
	}
	
	public Rook(final int x, final int y, final int limit) {
		super(x, y, limit);
		this.setMovement();
	}
	
	public Rook() {
		super();
		this.setMovement();
	}
	
	public Square getType(){
		return Square.ROOK;
	}

	@Override
	public void setMovement() { 

		int y = -1;
		int x = -1;
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(x==0 || y==0){
					super.movement[i][j][0] = x;
					super.movement[i][j][1] = y;
				}
				else{
					super.movement[i][j][0] = 0;
					super.movement[i][j][1] = 0;
				}
				x++;
			}
			y++;
			x=-1;
		}
		
	}

}
