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
		int yStart;
		int singleStep;
		int doubleStep;
		boolean isPossibility = false;
		Piece fieldAtTo = board.getPieceAt(new Coordinate(xTo, yTo));
		Color pawnColor = board.getPieceAt(from).getColor();

		if (pawnColor == Color.WHITE) {
			yStart = 2;
			singleStep = 1;
			doubleStep = 2;
		} else {
			yStart = 6;
			singleStep = -1;
			doubleStep = -2;
		}
		if (yFrom == yStart && ((yFrom + singleStep) == yTo && fieldAtTo == null)) {
			isPossibility = true;
			if ((xFrom - 1 == xTo) || (xFrom + 1 == xTo)) {
				return isPossibility;
			}
			return isPossibility;

		} else if (yFrom == yStart && ((yFrom + doubleStep) == yTo && fieldAtTo == null)) {
			if (board.getPieceAt(new Coordinate(xFrom, yFrom + singleStep)) == null) {
				isPossibility = true;
				return isPossibility;
			}
			return isPossibility;
		} else if (yFrom != yStart && (yFrom + singleStep) == yTo && fieldAtTo == null) {
			isPossibility = true;
			return isPossibility;
		}
		return isPossibility;
	}

}
