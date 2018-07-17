package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

public interface PieceOnBoard {

	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board);

}
