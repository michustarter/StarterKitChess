package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

public class Queen implements PieceOnBoard {

	Bishop bishop = new Bishop();
	Rook rook = new Rook();
	/*
	 * Je�li b�dzie b��d tutaj - to moze przeniesc te deklaracje bishop i rook
	 * do wn�trza metody!
	 */

	@Override
	public boolean isPathPossible(Coordinate from, Coordinate to, Board board) {

		boolean bishopPath = bishop.isPathPossible(from, to, board);
		boolean rookPath = rook.isPathPossible(from, to, board);

		return bishopPath || rookPath;

	}
}
