package pieces;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import game.Board;
import game.Square;

/**
 * 
 * @author Luis
 *
 * Abstract class for all the different pieces.
 */
public abstract class Piece implements IPiece{
	
	protected Point point = new Point();
	protected ArrayList<Point> movement = new ArrayList<Point>();
	
	public Piece (){}
	
	public Piece (final int x, final int y){
		this.point.x = x;
		this.point.y = y;
	}
	
	/**
	 * Calculates all the possible movements of one piece. If this piece
	 * does not threaten other pieces the function returns the board
	 * with the piece in it and all the threatened squares.
	 * Otherwise if the piece threatens other pieces the function return null.
	 * 
	 * @param board
	 * @return the new board with the piece and the threatened squares or null.
	 */
	public Board threatenedSquares(final Board board) {
		
		//The original board can not be modified
		Board boardAux = board.clone();
		
		//It is not necessary to check the movements if the sqare is alredy occupated 
		if(boardAux.isFree(this.point.y, this.point.x)){
			//Depending on the piece the algorithm are different
			if(Square.KING.equals(this.getType()) || Square.KNIGHT.equals(this.getType())){
				this.threatenedSquaresB(boardAux);
			}
			else{
				this.threatenedSquaresA(boardAux);
			}								
		}
		else{
			return null;
		}
		
		return boardAux;
	}
	
	/**
	 * Searches for threatened squares. This method is made for the pieces which are able to
	 * threaten more than one square in each direction (Queen, Rook and Knight). Inside of the list 'movements' 
	 * are all the possible directions of each piece. The algorithm checks all the nearest squares in the first
	 * iteration and if all the squares are free the algorithm checks one square beyond. When the
	 * square that it is been checking is outside of the board the direction is removed from the list.
	 * The algorithm ends when the list is empty or the square that is been checking is occupied.
	 * 
	 * @param board
	 */
	private void threatenedSquaresA(Board board) {
		
		//Places the piece in the square
		board.setSquare(this.point.y, this.point.x, this.getType());
		
		int iter = 0;
		int posX;
		int posY;
		Point point;
		int aux;
		
		//The original movement can not be modified
		List<Point> movementAux = (ArrayList<Point>)this.movement.clone();
		
		//This while ends when all the directions are removed form the list
		while(!movementAux.isEmpty()){
			//iter is increased in one each iteration to keep expanding the movement all over the board
			iter++;
			aux=0;
			//This while ends when the algorithm has checked the last position of the list
			while(aux < movementAux.size()){
				//point has the direction 
				point = movementAux.get(aux);
				//the positions of the direction are multiplied for the iteration and 
				//add to the position of the piece
				posX = (point.x * iter) + this.point.x;
				posY = (point.y * iter) + this.point.y;
				if(board.isInsideBoard(posY, posX)){
					if(board.isValid(posY, posX)){
						board.getSquares()[posY][posX] = Square.THREATED;
						aux++;
					}
					else{
						//This means that one occupied square has been found. The algorithm has to end here.
						board = null;
					}
				}
				else{
					//It is not necessary to keep checking this direction
					movementAux.remove(point);
				}
			}
		}
	}
	
	/**
	 * Searches for threatened squares. This method is made for the King and Knight because they threaten
	 * just one square in each direction. This case is easier than the previous one because the algorithm only
	 * needs to check the directions inside 'movements' one time.
	 * 
	 * @param board
	 */
	private void threatenedSquaresB(Board board) {
		
		//Places the piece in the square
		board.setSquare(this.point.y, this.point.x, this.getType());
		
		int posX;
		int posY;
		Point point;
		
		//This for ends when all the positions has been checked
		for(int i=0; i<this.movement.size(); i++){
			//point has the direction
			point = this.movement.get(i);
			//the positions of the direction are multiplied for the iteration and 
			//add to the position of the piece
			posX = point.x + this.point.x;
			posY = point.y + this.point.y;
			if(board.isInsideBoard(posY, posX)){
				if(board.isValid(posY, posX)){
					board.getSquares()[posY][posX] = Square.THREATED;
				}
				else{
					//This means that one occupied square has been found. The algorithm has to end here.
					board = null;
				}
			}
		}
		
	}
	
	/**
	 * Sets the list with the possible movements for the King and the Queen
	 */
	public void setMovement() { 
		
		for(int i=-1; i<2; i++){
			for(int j=-1; j<2; j++){
				this.movement.add(new Point(i,j));
			}
		}
		
		//The position where the piece is placed has to be removed
		this.movement.remove(new Point(0,0));
		
	}
	
	/*Getters and setters */
	
	public void setX(final int x){
		this.point.x = x;
	}
	
	public int getX(){
		return this.point.x;
	}
	
	public void setY(final int y){
		this.point.y = y;
	}
	
	public int getY(){
		return this.point.y;
	}
}
