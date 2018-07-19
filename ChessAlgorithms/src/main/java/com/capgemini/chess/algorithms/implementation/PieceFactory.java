package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.enums.PieceType;

/**
 * Klasa opiera siê na wzorcu Factory - zawiera metodê, która na podstawie
 * podanego typu bierki zwraca obiekt klasy, który reprezentuje dan¹ figurê.
 * Umo¿liwia to póŸniej wywo³anie metody której implementacja jest inna dla
 * ka¿dego rodzaju bierki.
 * 
 * @author MRATAJCZ
 *
 */
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
			piece = new Pawn();
			break;
		}
		return piece;

	}
}
