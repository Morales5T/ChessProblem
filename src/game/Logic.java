package game;

import java.util.ArrayList;

import pieces.IPiece;

public class Logic {
	
	public static void init(final Board board, final ArrayList<IPiece> pieces){
		
		int index=0;
		IPiece piece;
		Board boardAux;
		
		while(!pieces.isEmpty()){
			piece = pieces.remove(index);
			for(int i=0; i<board.getLimitY(); i++){
				piece.setY(i);
				for(int j=0; j<board.getLimitX(); j++){
					piece.setX(j);
					boardAux = piece.threatenedSquares(board);
					if(pieces.isEmpty() && (null != boardAux)){
						Game.mSolutions.add(boardAux);
					}
					if ( null == boardAux){			
						init(boardAux, pieces);
					}									
				}
			}
			index++;
		}
	}

}
