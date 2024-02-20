package chess.pieces;
import chess.Move;
import chess.board.*;
import java.util.ArrayList;

public class Bishop extends Piece {
	
	public Bishop(boolean isWhite, Place square) {
		super(isWhite, false, square, "Bishop");
	
	}

	@Override
	public ArrayList<Move> getLegalMoves(Board board, Place square) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		int n = 1;
		while (square.getX() + n < 8 && square.getY() + n < 8) {
			if (board.getSquare((square.getX() + n), square.getY() + n) != null) {
			if (board.getSquare((square.getX() + n), square.getY() + n).getPiece() == null) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() + n)));		
			} else if (board.getSquare((square.getX() + n), square.getY() + n).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() + n)));
				break;
			} else {
				break;
			}}
			n++;
		}
		
		n = 1;
		
		while (square.getX() - n > 0 && square.getY() - n > 0) {
			if (board.getSquare((square.getX() - n), square.getY() - n) != null){
			if (board.getSquare((square.getX() - n), square.getY() - n).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() - n)));		
		} else if (board.getSquare((square.getX() - n), square.getY() - n).getPiece().isWhite() != this.isWhite()) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() - n)));
			break;
		} else {
			break;
		}}
		n++;
	}
		
n = 1;
		
		while (square.getX() - n > 0 && square.getY() + n < 8) {
			if (board.getSquare((square.getX() - n), square.getY() + n) != null) {
			if (board.getSquare((square.getX() - n), square.getY() + n).getPiece() == null) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() + n)));		
			} else if (board.getSquare((square.getX() - n), square.getY() + n).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() + n)));
				break;
			} else {
				break;
			}}
		n++;
	}
		
		n = 1;
		
		while (square.getX() + n > 0 && square.getY() - n > 0) {
			if (board.getSquare((square.getX() + n), square.getY() - n) != null) {
		if (board.getSquare((square.getX() + n), square.getY() - n).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() - n)));		
		} else if (board.getSquare((square.getX() + n), square.getY() - n).getPiece().isWhite() != this.isWhite()) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() - n)));
			break;
		} else {
			break;
		}}
		n++;
	}
		return legalMoves;
	}

}
