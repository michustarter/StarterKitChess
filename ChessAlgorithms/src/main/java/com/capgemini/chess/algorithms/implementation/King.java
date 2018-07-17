package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class King implements PieceOnBoard {

	@Override
	public void determinePath(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		/*
		 * TYLKO TO PONI¯EJ SPR: tutaj pole TO moze byæ jedynie +-1 oddalone od
		 * pola from, inna figura moze stac (juz  spr czy inny kolor na pewno w Validation)
		 */
		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		Piece movedPiece = board.getPieceAt(from); // pobieram juz konkretna
													// Króla - Bia³ego lub
													// Czarnego

		if (xTo == xFrom - 1 || xTo == xFrom || xTo == xFrom + 1) {
			if (yTo == yFrom - 1 || yTo == yFrom || yTo == yFrom + 1) {
				board.setPieceAt(movedPiece, to);
				board.setPieceAt(null, from);
				return;
			}

		} else {
			throw new InvalidMoveException();
		}

	}
}
