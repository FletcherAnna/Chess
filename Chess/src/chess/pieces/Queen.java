package chess.pieces;

import java.util.ArrayList;

import chess.Move;
import chess.board.*;

public class Queen extends Piece{

	

	public Queen(boolean isWhite, Place square) {
		super(isWhite,false, square, "Queen");
	}

	@Override
	public ArrayList<Move> getLegalMoves(Board board, Place square) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		int n = 1;
		
		while (square.getX() + n < 8 && square.getY() + n < 8) {
		
			if (board.getSquare((square.getX() + n), square.getY() + n).getPiece() == null) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() + n)));		
			} else if (board.getSquare((square.getX() + n), square.getY() + n).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() + n)));
				break;
			} else {
				break;
			}
			n++;
		}
		
		n = 1;
		
		while (board.getSquare(square.getX() - n, square.getY() - n) != null) {
		if (board.getSquare((square.getX() - n), square.getY() - n).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() - n)));		
		} else if (board.getSquare((square.getX() - n), square.getY() - n).getPiece().isWhite() != this.isWhite()) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() - n)));
			break;
		} else {
			break;
		}
		n++;
	}
		
		n = 1;
		
		while (board.getSquare(square.getX() - n, square.getY() + n) != null) {
			if (board.getSquare((square.getX() - n), square.getY() + n).getPiece() == null) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() + n)));		
			} else if (board.getSquare((square.getX() - n), square.getY() + n).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY() + n)));
				break;
			} else {
				break;
			}
		n++;
	}
		
		n = 1;
		
		while (board.getSquare(square.getX() + n, square.getY() - n) != null) {
		if (board.getSquare((square.getX() + n), square.getY() - n).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() - n)));		
		} else if (board.getSquare((square.getX() + n), square.getY() - n).getPiece().isWhite() != this.isWhite()) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY() - n)));
			break;
		} else {
			break;
		}
		n++;
	}
		
		n = 1;
		
		while (board.getSquare((square.getX() + n), square.getY()) != null) {
			
			if (board.getSquare((square.getX() + n), square.getY()).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY())));		
			} else if (board.getSquare((square.getX() + n), square.getY()).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY())));
				break;
			} else {
				break;
			}
			n++;
		}
		
		
		
		n = 1;
		while (board.getSquare((square.getX() - n), square.getY()) != null) {
			
			if (board.getSquare((square.getX() - n), square.getY()).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY())));		
			} else if (board.getSquare((square.getX() - n), square.getY()).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - n), square.getY())));
				break;
			} else {
				break;
			}
			n++;
		}

		n = 1;
		while (board.getSquare((square.getX()), (square.getY() + n)) != null) {
			
			if (board.getSquare((square.getX()), (square.getY() + n)).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX()), (square.getY() + n))));		
			} else if (board.getSquare((square.getX()), (square.getY() + n)).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX()), square.getY()+ n)));
				break;
			} else {
				break;
			}
			n++;
		}
		n = 1;
		while (board.getSquare((square.getX()), (square.getY() - n)) != null) {
			
			if (board.getSquare((square.getX()), (square.getY() - n)).getPiece() == null) {
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX()), (square.getY() - n))));		
			} else if (board.getSquare((square.getX()), (square.getY() - n)).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() ), square.getY()- n)));
				break;
			} else {
				break;
			}
			n++;
		}
		return legalMoves;
				
	}
}
