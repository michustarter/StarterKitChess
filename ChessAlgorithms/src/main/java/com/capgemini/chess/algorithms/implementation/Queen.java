package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class Queen implements PieceOnBoard {

	Bishop bishop = new Bishop();
	Rook rook = new Rook();
	/*
	 * Jeœli bêdzie b³¹d tutaj - to moze przeniesc te deklaracje bishop i rook do wnêtrza metody!
	 */

	@Override
	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		boolean bishopPath = bishop.isMoveToDestination(from, to, board);
		boolean rookPath = rook.isMoveToDestination(from, to, board);

		return bishopPath || rookPath;

	}
}
