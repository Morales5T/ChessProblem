package pieces;

import game.Board;
import game.Square;

public class Queen extends Piece{
	
	public Queen(final int x, final int y) {
		super(x, y);
	}
	
	public Queen() {
		super();
	}

	@Override
	public Board threatenedSquares(Board board) {

		if(board.isFree(super.getY(), super.getX())){
			
			board.getBoard()[super.getY()][super.getX()] = Square.QUEEN;
			
			boolean end = false;
			int count = 0;
			int iter = 0;
			int posX;
			int posY;
			
			while(!end){
				iter++;
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){
						if(!((super.movement[i][j][0] == 0) && (super.movement[i][j][1] == 0))){
							posX = (super.movement[i][j][0] * iter) + super.getX();
							posY = (super.movement[i][j][1] * iter) + super.getY();
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
								super.movement[i][j][0] = 0;
								super.movement[i][j][1] = 0;
							}
						}
					}					
				}
				end = count == 8;
			}
		}
		else{
			return null;
		}
		
		return board;
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
