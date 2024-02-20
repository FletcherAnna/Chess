package chess.pieces;
import chess.Move;
import chess.board.*;
import java.util.ArrayList;

public class Rook extends Piece {


	public Rook(boolean isWhite, Place square) {
		super(isWhite, false, square, "Rook");

	}


	@Override
	public ArrayList<Move> getLegalMoves(Board board, Place square) {
		ArrayList<Move> legalMoves = new ArrayList<Move>();
		
		int n = 1;
		while(board.getSquare(square.getX() + n, square.getY()) != null) {
			
			if (board.getSquare((square.getX() + n), square.getY()).getPiece() == null) {
				
			legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY())));
			
			} else if (board.getSquare((square.getX() + n), square.getY()).getPiece().isWhite() != this.isWhite()) {
				legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + n), square.getY())));
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
			} else {
				break;
			}
			n++;
		}
		return legalMoves;
	}

}
