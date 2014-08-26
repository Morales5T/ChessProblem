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
		
		IPiece piece = pieces.remove(0);
		Board boardAux;
		boolean aux;
		
		//Every single position has to be checked
		for(int i=0; i<board.getSquares().length; i++){
			piece.setY(i);
			for(int j=0; j<board.getSquares()[0].length; j++){
				piece.setX(j);
				//If the piece can be placed boardAux is the new board with the new piece placed,
				//else boardAux is null
				boardAux = piece.threatenedSquares(board);
				//Finally if the piece could be placed, the list of pieces is empty 
				//(it means that we are in the deepest level of the tree) and the solution is not 
				//already in the list of solutions it´s added
				aux = (null != boardAux) && !contains(solutions, boardAux);
				if(pieces.isEmpty() && aux){
					solutions.add(boardAux);
				//If the piece could be placed,the solution is not already in the list of solutions 
			    //and the list of pieces is not empty it goes one level deeper in the tree
				}else if (aux){			
					findSolution(boardAux, copyOf(pieces), solutions); 
				}									
			}
		}
	}
	
	/**
	 * Returns a copy of the original list
	 * 
	 * @param pieces
	 * @return
	 */
	private static ArrayList<IPiece> copyOf(final ArrayList<IPiece> pieces){
		return (ArrayList<IPiece>)pieces.clone();
	}
	
	/**
	 * Checks if the board is already a solution
	 * 
	 * @param solutions list of solutions
	 * @param board single case to compare with the list cases
	 * @return
	 */
	private static boolean contains(final List<Board> solutions, final Board board){
		for(Board b : solutions){
			if(board.equals(b)){
				return true;
			}
		}
		return false;
	}

}
