package chess.board;

import chess.pieces.Piece;

public class Place {

	private Piece piece;
	//location
	protected final int x;
	protected final int y;

public Place(int x, int y, Piece piece) {
	this.x = x;
	this.y = y;
	this.setPiece(piece);
}

public Piece getPiece() {
	return this.piece;
}

public void setPiece(Piece p){
	this.piece = p;
}

//location methods

public int getX() {
	return this.x;
}

public int getY() {
	return this.y;
}


}

