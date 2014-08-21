package pieces;

public class Bishop extends Piece{
	
	public Bishop(final int x, final int y, final int limit) {
		super(x, y, limit);
		this.setMovement();
	}
	
	public Bishop() {
		super();
		this.setMovement();
	}

	@Override
	public void setMovement() {
		
		int y = -1;
		int x = -1;
		
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				if(!(x==0 || y==0)){
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
