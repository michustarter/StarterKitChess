package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class Queen implements PieceOnBoard {

	Bishop bishop = new Bishop();
	Rook rook = new Rook();

	@Override
	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		boolean isPossibility = false;
		boolean bishopPath = bishop.isMoveToDestination(from, to, board);
		boolean rookPath = rook.isMoveToDestination(from, to, board);

		if (bishopPath || rookPath) {
			isPossibility = true;
			return isPossibility;
		}
		return isPossibility;
	}
}
