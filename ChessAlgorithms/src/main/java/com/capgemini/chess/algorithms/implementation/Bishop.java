package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

public class Bishop implements PieceOnBoard {

	@Override
	public boolean isPathPossible(Coordinate from, Coordinate to, Board board) {
		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isPossibility = false;

		if (xFrom <= xTo) {
			int i = 0;
			if (yFrom <= yTo) {
				while (yFrom <= yTo) {
					if ((xFrom + i == xTo) && (yFrom + i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom + i)) != null) {
						isPossibility = false;
						return isPossibility;
					}
					i++;
				}
			} else if (yFrom >= yTo) {
				while (yFrom >= yTo) {
					if ((xFrom + i == xTo) && (yFrom - i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom - i)) != null) {
						isPossibility = false;
						return isPossibility;
					}
					i++;
				}
			}
		}
		if (xFrom >= xTo) {
			int i = 0;
			if (yFrom <= yTo) {
				while (yFrom <= yTo) {
					if ((xFrom - i == xTo) && (yFrom + i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom - i, yFrom + i)) != null) {
						isPossibility = false;
						return isPossibility;
					}
					i++;
				}
			} else if (yFrom >= yTo) {
				while (yFrom >= yTo) {
					if ((xFrom - i == xTo) && (yFrom - i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom - i, yFrom - i)) != null) {
						isPossibility = false;
						return isPossibility;
					}
					i++;
				}
			}
		}
		return isPossibility;
	}
}
