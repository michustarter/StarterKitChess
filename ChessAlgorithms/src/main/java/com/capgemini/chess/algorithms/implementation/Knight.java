package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class Knight implements PieceOnBoard {

	@Override
	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isPossibility = false;

		if ((xFrom - 1) == xTo || (xFrom + 1) == xTo) {
			if ((yFrom - 2) == yTo || (yFrom + 2) == yTo) {
				isPossibility = true;
				return isPossibility;
			}
		} else if ((xFrom - 2) == xTo || (xFrom + 2) == xTo) {
			if ((yFrom - 1) == yTo || (yFrom + 1) == yTo) {
				isPossibility = true;
				return isPossibility;
			}
		}
		return isPossibility;
	}
}
