package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.enums.PieceType;

public class PieceFactory {
	private PieceOnBoard piece = null;

	public PieceOnBoard returnPiece(PieceType type) {

		switch (type) {
		case KING:
			piece = new King();
			//break;
		case QUEEN:
			piece = new Queen();
			//break;
		case BISHOP:
			piece = new Bishop();
			//break;
		case KNIGHT:
			piece = new Knight();
			//break;
		case ROOK:
			piece = new Rook();
			//break;
		case PAWN:
			piece = new Pawn();
			//break;
		}
		return piece;

	}
}
