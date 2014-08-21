package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import pieces.Bishop;
import pieces.IPiece;
import pieces.King;
import pieces.Knight;
import pieces.Queen;
import pieces.Rook;


public class Game {
	
	private static final String CTE_NUMBER_ERROR = "Please introduce a valid number";
	
	public static void main(String args[]){
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Please, introduce the size MxN of the board:");
		int m = getNumber(br, "M:");
		int n = getNumber(br, "N:");
		
		Board board = new Board(new Square[m][n]);
		
		System.out.println("Please, introduce the number of pieces of each type:");
		
		int nKings = getNumber(br, "King:");
		int nKnights = getNumber(br, "Knight:");
		int nQueens = getNumber(br, "Queen:");
		int nRooks = getNumber(br, "Rook:");
		int nBishops = getNumber(br, "Bishop:");
		
		ArrayList<IPiece> pieces = new ArrayList<IPiece>();
		pieces.addAll(createPieces(nKings, 0));
		pieces.addAll(createPieces(nKnights, 1));
		pieces.addAll(createPieces(nQueens, 2));
		pieces.addAll(createPieces(nRooks, 3));
		pieces.addAll(createPieces(nBishops, 4));
		
		IPiece piece = pieces.get(0);
		board = piece.threatenedSquares(board);
		board.printBoard();
		
		//Logic.init(board, pieces);		
	}
	
	/**
	 * Returns the number introduced by the user. 
	 * The user has to introduce a correct number to continue with the program.
	 * When the user is introducing the size of the board the number has to be bigger than 0.
	 * When the user is introducing the number of pieces the number has to be positive.
	 * 
	 * @param br BufferedReader
	 * @param output Side of the board
	 * @return number formated
	 */
	private static int getNumber(final BufferedReader br, final String output){
		int x = 0;
		boolean exit = false;
		
		while(!exit){
			try {
				System.out.print(output);
				String input = br.readLine();
				if(input != null && input.length() > 0){
					x = Integer.parseInt(input);
					if("M:".equals(output) || "N:".equals(output)){
						exit = x>0;
					}
					else if(x>=0){
						exit = true;
					}				
				}	
				
				if(!exit){
					System.out.println(Game.CTE_NUMBER_ERROR);
				}
			} catch (IOException e) {
				System.out.println(Game.CTE_NUMBER_ERROR);
			} catch (NumberFormatException e1) {
				System.out.println(Game.CTE_NUMBER_ERROR);
			}
		}
		
		return x;
	}
	
	private static ArrayList<IPiece> createPieces(final int n, final int type){
		
		ArrayList<IPiece> pieces = new ArrayList<IPiece>();
		
		for(int i=0; i< n; i++){
			switch(type){
				case 0:
					pieces.add(new King(2,2));
					break;
				case 1:
					pieces.add(new Knight(2,2));
					break;	
				case 2:
					pieces.add(new Queen(2,2,8));
					break;
				case 3:
					pieces.add(new Rook(2,2,4));
					break;
				case 4:
					pieces.add(new Bishop(2,2,4));
					break;
			}
		}
		
		return pieces;
	}
}