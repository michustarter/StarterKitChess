package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public interface PieceOnBoard {

	public void determinePath(Coordinate from, Coordinate to, Board board) throws InvalidMoveException;

}