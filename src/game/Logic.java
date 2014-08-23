package game;

import java.util.ArrayList;
import java.util.List;

import pieces.IPiece;

public class Logic {
	
	public static void init(final Board board, final ArrayList<IPiece> pieces, final List<Board> solutions){
		
		int index=0;
		IPiece piece;
		Board boardAux;
		
		while(index < pieces.size()){
			piece = pieces.remove(index);
			for(int i=0; i<board.getSquares().length; i++){
				piece.setY(i);
				for(int j=0; j<board.getSquares()[0].length; j++){
					piece.setX(j);
					boardAux = piece.threatenedSquares(board);
					if(pieces.isEmpty() && (null != boardAux)){
						solutions.add(boardAux);
					}
					if ( null != boardAux){			
						init(boardAux, copyOf(pieces), solutions); 
					}									
				}
			}
			index++;
		}
	}
	
	private static ArrayList<IPiece> copyOf(final ArrayList<IPiece> pieces){
		return (ArrayList<IPiece>)pieces.clone();
	}

}
