package chess.pieces;
import chess.Move;
import chess.board.*;
import java.util.ArrayList;

public abstract class Piece {
	private boolean isLive = true;
	private final boolean isWhite;
	protected final boolean isKing;
	protected boolean hasMoved = false;
	protected Place square;
	protected String type;
	protected int numberOfMoves = 0;
	
	public int getNumberOfMoves() {
		return numberOfMoves;
	}

	public void incNumberOfMoves() {
		this.numberOfMoves = this.numberOfMoves + 1;
	}
	
	public void decNumberOfMoves() {
		if (this.numberOfMoves > 0) {
		this.numberOfMoves = this.numberOfMoves - 1;
		}
	}

	public Place getSquare() {
		return square;
	}

	public void setSquare(Place square) {
		this.square = square;
	}

	public abstract ArrayList<Move> getLegalMoves(Board board, Place square); 
	
	public boolean canMove(Board board, Place end) {
		for (Move p: getLegalMoves(board, square)) {
			if (p.getEnd() == end) {
				return true;
			}
		}
		return false;
	}
	
	// if piece can capture a King, return true
	public boolean canCheck(Board board) {
		for (Move p : getLegalMoves(board, square)) {
			if (p.getKilledPiece().isKing) {
				return true;
			}
		}
		return false;
	}
		
	
	public Piece(boolean isWhite, boolean isKing, Place location, String type) {
		this.isWhite = isWhite;
		this.isKing = isKing;
		this.square = location;
		this.type = type;
	}
	

	public boolean isWhite() {
		return this.isWhite;
	}
	
	
	public boolean isLive() {
		return this.isLive;
	}
	
	public void setLive(boolean l) {
		this.isLive = l;
	}
	
	public boolean isKing() {
		return this.isKing;
	}

	public boolean hasMoved() {
		return this.hasMoved;
	}

	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}
	
	public String getType() {
		return this.type;
	}
	
}


