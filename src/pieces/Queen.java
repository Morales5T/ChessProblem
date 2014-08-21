package pieces;

public class Queen extends Piece{
	
	public Queen(final int x, final int y, final int limit) {
		super(x, y, limit);
		this.setMovement();
	}
	
	public Queen() {
		super();
		this.setMovement();
	}

	@Override
	public void setMovement() {
		
		int y = -1;
		int x = -1;
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				super.movement[i][j][0] = x;
				super.movement[i][j][1] = y;
				x++;
			}
			y++;
			x=-1;
		}
		
	}

}
