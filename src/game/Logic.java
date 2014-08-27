package game;

import java.util.ArrayList;
import java.util.HashMap;

import pieces.IPiece;

/**
 * 
 * @author Luis
 *
 * This class contains the algorithm to fin the solutions.
 */
public class Logic {
	
	public static void findSolution(final Board board, final ArrayList<IPiece> pieces, final HashMap<String, Board> solutions){
		
		IPiece piece = pieces.remove(0);
		Board boardAux;
		String key = "";
		
		//Every single position has to be checked
		for(int i=0; i<board.getSquares().length; i++){
			piece.setY(i);
			for(int j=0; j<board.getSquares()[0].length; j++){
				piece.setX(j);
				//If the piece can be placed boardAux is the new board with the new piece placed,
				//else boardAux is null
				boardAux = piece.threatenedSquares(board);
				if(null != boardAux){
					//Now the algorithm uses an hashmap to save the solutions because is much more efficient
					//so it needs a unique key to save every solution
					key = getKey(boardAux);
					//Finally if the piece could be placed, the list of pieces is empty 
					//(it means that we are in the deepest level of the tree) and the solution is not 
					//already in the list of solutions it´s added
					if(pieces.isEmpty() && !solutions.containsKey(key)){	
						solutions.put(key, boardAux);
					}
					else if(!solutions.containsKey(key)){
						//If the piece could be placed,the solution is not already in the list of solutions 
						//and the list of pieces is not empty it goes one level deeper in the tree
						findSolution(boardAux, copyOf(pieces), solutions); 
					}	
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
	 * Builds an unique key for every solution if the board is already a solution
	 * 
	 * @param board solution
	 * @return unique key
	 */
	private static String getKey(final Board board){
		
		String key = "";
		
		for(int i=0; i<board.getSquares().length; i++){
			for(int j=0; j<board.getSquares()[0].length; j++){
				if(!board.getSquare(i, j).equals(Square.FREE) && !board.getSquare(i, j).equals(Square.THREATED)){
					key = key + board.getSquare(i, j).toString() + i + j;
				}
			}
		}
		
		return key;
	}

}
