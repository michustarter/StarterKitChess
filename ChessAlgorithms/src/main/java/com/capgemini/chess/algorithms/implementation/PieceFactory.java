package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.enums.PieceType;

public class PieceFactory {

	public static PieceOnBoard returnPiece(PieceType type) {
		PieceOnBoard piece = null;

		switch (type) {
		case KING:
			piece = new King();
			break;
		case QUEEN:
			piece = new Queen();
			break;
		case BISHOP:
			piece = new Bishop();
			break;
		case KNIGHT:
			piece = new Knight();
			break;
		case ROOK:
			piece = new Rook();
			break;
		case PAWN:
			piece = new Pawn(); // bez break zwroci mi zawsze Pawn!!!!!
			break;
		}
		return piece;

	}
}
