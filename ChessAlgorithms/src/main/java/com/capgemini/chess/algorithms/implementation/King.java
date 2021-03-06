package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

public class King implements PieceOnBoard {

	@Override
	public boolean isPathPossible(Coordinate from, Coordinate to, Board board) {

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isPossibility = false;

		if (xTo == xFrom - 1 || xTo == xFrom || xTo == xFrom + 1) {
			if (yTo == yFrom - 1 || yTo == yFrom || yTo == yFrom + 1) {
				isPossibility = true;
				return isPossibility;
			}
		} else {
			isPossibility = false;
		}
		return isPossibility;
	}
}
