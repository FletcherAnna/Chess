package chess.pieces;
import chess.Move;
import chess.board.*;
import chess.pieces.Piece;
import java.util.ArrayList;



public class Knight extends Piece {


	public Knight(boolean isWhite, Place square) {
		super(isWhite, false, square, "Knight");
	
	}


	@Override
	public ArrayList<Move> getLegalMoves(Board board, Place square) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		//get candidate moves
		int x = this.getSquare().getX();
		int y = this.getSquare().getY();
		
		if (board.getSquare((x -1), (y -2)) != null){
			if(board.getSquare((x - 1), y - 2).getPiece() != null) {
				if(board.getSquare((x-1), y - 2).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x-1, y-2)));
				}
			} else {
				legalMoves.add(new Move(null, this, square, board.getSquare(x-1, y-2)));
			}
		}
		
		if (board.getSquare((x +1), (y -2)) != null){
			if(board.getSquare((x+1), y-2).getPiece() != null) {
				if(board.getSquare((x+1), y-2).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x+1, y-2)));
				}
		} else {
			legalMoves.add(new Move(null, this, square, board.getSquare(x+1, y-2)));
			}
		}
		
		if (board.getSquare((x -1), (y +2)) != null){
			if(board.getSquare((x-1), y+2).getPiece() != null) {
				if(board.getSquare((x-1), y+2).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x-1, y+2)));
			}
		} else {
			legalMoves.add(new Move(null, this, square, board.getSquare(x-1, y+2)));
			}
		}
		
		if (board.getSquare((x +1), (y +2)) != null){
			if(board.getSquare((x+1), y+2).getPiece() != null) {
				if(board.getSquare((x+1), y+2).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x+1, y+2)));
			}
		} else {
			legalMoves.add(new Move(null, this, square, board.getSquare(x+1, y+2)));
			}
		}
		
		if (board.getSquare((x -2), (y -1)) != null){
			if(board.getSquare((x-2), y-1).getPiece() != null) {
				if(board.getSquare((x-2), y-1).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x-2, y-1)));
			}
		} else {
			legalMoves.add(new Move(null, this, square, board.getSquare(x-2, y-1)));
			}
		}
		
		if (board.getSquare((x +2), (y -1)) != null){
			if(board.getSquare((x+2), y-1).getPiece() != null) {
				if(board.getSquare((x+2), y-1).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x+2, y-1)));
				}
			} else {
				legalMoves.add(new Move(null, this, square, board.getSquare(x+2, y-1)));
				}
		}
		if (board.getSquare((x -2), (y +1)) != null){
			if(board.getSquare((x-2), y+1).getPiece() != null) {
				if(board.getSquare((x-2), y+1).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x-2, y+1)));
				}
			} else {
				legalMoves.add(new Move(null, this, square, board.getSquare(x-2, y+1)));
				}
		}
		if (board.getSquare((x +2), (y +1)) != null){
			if(board.getSquare((x+2), y+1).getPiece() != null) {
				if(board.getSquare((x+2), y+1).getPiece().isWhite() != this.isWhite()) {
					legalMoves.add(new Move(null, this, square, board.getSquare(x+2, y+1)));
			}
		} else {
			legalMoves.add(new Move(null, this, square, board.getSquare(x+2, y+1)));
			}
		}
		
		return legalMoves;
	}
	
		

}
