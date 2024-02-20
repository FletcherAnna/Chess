package chess.pieces;
import java.util.ArrayList;

import chess.Move;
import chess.board.*;


public class King extends Piece {


	public King(boolean isWhite, Place square) {
			super(isWhite, true, square, "King");
		}

		@Override
		public ArrayList<Move> getLegalMoves(Board board, Place square) {
			ArrayList<Move> legalMoves = new ArrayList<Move>();
			
			
				if (square.getX() < 8) {
					if (board.getSquare((square.getX() + 1), square.getY()) != null) {
					if (board.getSquare((square.getX() + 1), square.getY()).getPiece() == null) {
						legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + 1), square.getY())));		
						} else if (board.getSquare((square.getX() + 1), square.getY()).getPiece().isWhite() != this.isWhite()) {
							legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() + 1), square.getY())));
						}
				}
				}	
			
				if (square.getX()> 0) {
					if (board.getSquare((square.getX() - 1), square.getY()) != null) {
					if (board.getSquare((square.getX() - 1), square.getY()).getPiece() == null) {
						legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - 1), square.getY())));		
					} else if (board.getSquare((square.getX() - 1), square.getY()).getPiece().isWhite() != this.isWhite()) {
						legalMoves.add(new Move(null, this, square, board.getSquare((square.getX() - 1), square.getY())));
					}

				}
				}
				
				if (square.getY() < 8) {
					if (board.getSquare((square.getX()), (square.getY() + 1)) != null) {						
					if (board.getSquare((square.getX()), (square.getY() + 1)).getPiece() == null) {
						legalMoves.add(new Move(null, this, square, board.getSquare((square.getX()), (square.getY() + 1))));
					} else if (board.getSquare((square.getX()), (square.getY() + 1)).getPiece().isWhite() != this.isWhite()) {
						legalMoves.add(new Move(null, this, square, board.getSquare((square.getX()), square.getY() + 1)));
					} 
				}
				}
				if (square.getY() > 0) {
					if (board.getSquare((square.getX()), (square.getY() - 1)) != null) {
					if (board.getSquare((square.getX()), (square.getY() - 1)).getPiece() == null) {
						legalMoves.add(new Move(null, this, square, board.getSquare((square.getX()), (square.getY() - 1))));		
					} else if (board.getSquare((square.getX()), (square.getY() - 1)).getPiece().isWhite() != this.isWhite()) {
						legalMoves.add(new Move(null, this, square, board.getSquare((square.getX()), square.getY() - 1)));
					}
					}
				}
			
			
			
			return legalMoves;
		}
		
	}


