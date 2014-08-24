package game;

import java.util.ArrayList;
import java.util.List;

import pieces.IPiece;

/**
 * 
 * @author Luis
 *
 * This class contains the algorithm to fin the solutions.
 */
public class Logic {
	
	public static void findSolution(final Board board, final ArrayList<IPiece> pieces, final List<Board> solutions){
		
		IPiece piece;
		Board boardAux;
		
		while(!pieces.isEmpty()){
			piece = pieces.remove(0);
			for(int i=0; i<board.getSquares().length; i++){
				piece.setY(i);
				for(int j=0; j<board.getSquares()[0].length; j++){
					piece.setX(j);
					boardAux = piece.threatenedSquares(board);
					if(pieces.isEmpty() && (null != boardAux)){
						solutions.add(boardAux);
					}else if ( null != boardAux){			
						findSolution(boardAux, copyOf(pieces), solutions); 
					}									
				}
			}
		}
	}
	
	private static ArrayList<IPiece> copyOf(final ArrayList<IPiece> pieces){
		return (ArrayList<IPiece>)pieces.clone();
	}

}
