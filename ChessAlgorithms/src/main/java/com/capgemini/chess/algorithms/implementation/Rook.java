package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class Rook implements PieceOnBoard {

	@Override
	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isPossibility = false;
		if (yFrom == yTo) {
			int i = 0;
			if (xFrom <= xTo) {
				while (xFrom + i <= xTo) {
					if (xFrom + i == xTo) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom)) != null) {
						isPossibility = false;
						return isPossibility;
					}
					i++;
				}
			} else if (xFrom >= xTo) {
				while (xFrom - i >= xTo) {
					if (xFrom - i == xTo) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom - i, yFrom)) != null) {
						isPossibility = false;
						return isPossibility;
					}
					i++;
				}
			}
		}
		if (xFrom == xTo) {
			int i = 0;
			if (yFrom <= yTo) {
				while (yFrom + i <= yTo) {
					if (yFrom + i == yTo) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom, yFrom + i)) != null) {
						isPossibility = false;
						return isPossibility;
					}
					i++;
				}
			} else if (yFrom >= yTo) {
				while (yFrom - i >= yTo) {
					if (yFrom - i == yTo) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom, yFrom - i)) != null) {
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
