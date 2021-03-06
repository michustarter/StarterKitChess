package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;

public class Pawn implements PieceOnBoard {

	@Override
	public boolean isPathPossible(Coordinate from, Coordinate to, Board board) {

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		int yStart = 1;
		int singleStep = 1;
		int doubleStep = 2;
		boolean isPossibility = false;
		Piece fieldAtTo = board.getPieceAt(new Coordinate(xTo, yTo));
		Color pawnColor = board.getPieceAt(from).getColor();

		if (pawnColor == Color.BLACK) {
			yStart = 6;
			singleStep = -1;
			doubleStep = -2;
		}

		if (yFrom == yStart && ((yFrom + singleStep) == yTo && board.getPieceAt(new Coordinate(xFrom, yTo)) == null)) {
			isPossibility = true;
			if ((xFrom - 1 == xTo) || (xFrom + 1 == xTo)) {
				return isPossibility;
			}
			return isPossibility;

		}
		if (yFrom == yStart
				&& ((yFrom + doubleStep) == yTo && board.getPieceAt(new Coordinate(xFrom, yFrom + singleStep)) == null)
				&& fieldAtTo == null) {
			isPossibility = true;
			return isPossibility;

		}
		if (yFrom != yStart && (yFrom + singleStep) == yTo && xFrom == xTo && fieldAtTo == null) {
			isPossibility = true;
			return isPossibility;
		} else if (yFrom != yStart && (yFrom + singleStep) == yTo
				&& board.getPieceAt(new Coordinate(xFrom, yTo)) == null && fieldAtTo != null) {
			if ((xFrom - 1 == xTo) || (xFrom + 1 == xTo)) {
				isPossibility = true;
				return isPossibility;
			}
		}
		return isPossibility;
	}

}
