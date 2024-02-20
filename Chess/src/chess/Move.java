package chess;

import chess.board.Place;
import chess.pieces.Piece;

/**
  * 
  * @author jerif
  *
  * Class to represent a Chess move. Not all moves need to be legal!
  */
public class Move {
	private Player player;
	private Piece movedPiece;
	private Place start;
	private Place end;
	private Piece killedPiece; // may be null
	
	
	public Move(Player player, Piece movedPiece, Place start, Place end) {
		this.start = start;
		this.end = end;
		this.player = player;
		this.movedPiece = movedPiece;
	}


	public Place getEnd() {
		return end;
	}

	public Place getStart() {
		return start;
	}
	
	public Piece getMovedPiece() {
		return movedPiece;
	}
	
	public Piece getKilledPiece() {
		return killedPiece;
	}
	
	public Player getPlayer() {
		return player;
	}

}
