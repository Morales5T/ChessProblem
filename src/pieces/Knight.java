package pieces;

import game.Board;
import game.Square;

public class Knight extends Piece{

	public Knight(final int x, final int y) {
		super(x, y);
		this.setMovement();
	}
	
	public Knight() {
		super();
		this.setMovement();
	}

	@Override
	public Board threatenedSquares(Board board) {
		
		//Check position where the piece is going to be placed
		if(board.isFree(super.getY(), super.getX())){
			
			//Place the piece
			board.getBoard()[super.getY()][super.getX()] = Square.KNIGHT;
			
			//Check positions
			if(board.isInsideBoard(super.getY()+1, super.getX()+2)){
				if(board.isValid(super.getY()+1, super.getX()+2)){
					board.getBoard()[super.getY()+1][super.getX()+2] = Square.THREATED;
				}else{
					return null;
				}
			}

			if(board.isInsideBoard(super.getY()-1, super.getX()+2)){
				if(board.isValid(super.getY()-1, super.getX()+2)){
					board.getBoard()[super.getY()-1][super.getX()+2] = Square.THREATED;
				}else{
					return null;
				}
			}
			
			if(board.isInsideBoard(super.getY()+2, super.getX()+1)){
				if(board.isValid(super.getY()+2, super.getX()+1)){
					board.getBoard()[super.getY()+2][super.getX()+1] = Square.THREATED;
				}else{
					return null;
				}
			}
			
			//Check position 2right/1down to place the piece
			if(board.isInsideBoard(super.getY()+2, super.getX()-1)){
				if(board.isValid(super.getY()+2, super.getX()-1)){
					board.getBoard()[super.getY()+2][super.getX()-1] = Square.THREATED;
				}else{
					return null;
				}
			}
			
			//Check position 2down/1right to place the piece
			if(board.isInsideBoard(super.getY()+1, super.getX()-2)){
				if(board.isValid(super.getY()+1, super.getX()-2)){
					board.getBoard()[super.getY()+1][super.getX()-2] = Square.THREATED;
				}else{
					return null;
				}
			}
			
			//Check position 2down/1left to place the piece
			if(board.isInsideBoard(super.getY()-1, super.getX()-2)){
				if(board.isValid(super.getY()-1, super.getX()-2)){
					board.getBoard()[super.getY()-1][super.getX()-2] = Square.THREATED;
				}else{
					return null;
				}
			}
			
			//Check position 2left/1up to place the piece
			if(board.isInsideBoard(super.getY()-2, super.getX()+1)){
				if(board.isValid(super.getY()-2, super.getX()+1)){
					board.getBoard()[super.getY()-2][super.getX()+1] = Square.THREATED;
				}else{
					return null;
				}
			}
			
			//Check position 2left/1down to place the piece
			if(board.isInsideBoard(super.getY()-2, super.getX()-1)){
				if(board.isValid(super.getY()-2, super.getX()-1)){
					board.getBoard()[super.getY()-2][super.getX()-1] = Square.THREATED;
				}else{
					return null;
				}
			}		
			
			return board;			
		}
		else{
			return null;
		}
	}

	@Override
	public void setMovement() {
		// TODO Auto-generated method stub
	}

}
