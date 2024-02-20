package chess.pieces;
import chess.Move;
import chess.board.*;
import java.util.ArrayList;


public class Pawn extends Piece {
	
	
	
	public Pawn(boolean isWhite, Place square) {
		super(isWhite, false, square, "Pawn");

	}
	

	@Override
	public ArrayList<Move> getLegalMoves(Board board, Place square) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		if(!this.isWhite()) {
			// go forward one space. If legal, add to the set
			if (square.getX() < 8) {
			
				if (board.getSquares()[square.getX() + 1][square.getY()].getPiece() == null) {
					legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() + 1][square.getY()]));		
				}
				//if the first move, can move two spaces forward
				if (!hasMoved && board.getSquares()[square.getX() + 2][square.getY()].getPiece() == null) {
					legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() + 2][square.getY()]));		
				}
				//capture right
				if (square.getY() < 7){
					if (board.getSquares()[square.getX() + 1][square.getY() + 1].getPiece() != null) {
						if (board.getSquares()[square.getX() + 1][square.getY() + 1].getPiece().isWhite() == true) {
							legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() + 1][square.getY() + 1]));		
						}
					}
				}
				//capture left
				if (square.getY() > 0){
					if (board.getSquares()[square.getX() + 1][square.getY() - 1].getPiece() != null) {
						if (board.getSquares()[square.getX() + 1][square.getY() - 1].getPiece().isWhite() == true) {
							legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() + 1][square.getY() - 1]));		
						}
					}
				}
			}	
		} else {
			
			if (square.getX() >= 0) {
				if (board.getSquares()[square.getX() - 1][square.getY()].getPiece() == null) {
					legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() - 1][square.getY()]));		
				}
				//if the first move, can move two spaces forward
				if (!hasMoved && board.getSquares()[square.getX() - 2][square.getY()].getPiece() == null) {
					legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() - 2][square.getY()]));		
				}
				//capture right
				if (square.getY() < 7){
					if (board.getSquares()[square.getX() - 1][square.getY() + 1].getPiece() != null) {
						if (board.getSquares()[square.getX() - 1][square.getY() + 1].getPiece().isWhite() == false) {
					
						legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() - 1][square.getY() + 1]));		
					}
				}
				}
				//capture left
				if (square.getY() > 0){
					if (board.getSquares()[square.getX() - 1][square.getY() - 1].getPiece() != null){
					if (board.getSquares()[square.getX() - 1][square.getY() - 1].getPiece().isWhite() == false) {
						legalMoves.add(new Move(null, this, square, board.getSquares()[square.getX() - 1][square.getY() - 1]));		
					}
				}
			}
			}
			
			
			
		}
		return legalMoves;
	}

}
