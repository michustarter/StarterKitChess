package com.capgemini.chess.algorithms.implementation.exceptions;

/**
 * Exception thrown in case the chosen chessboard fiels is null and does not
 * have any Piece
 */

public class NullFromFieldException extends InvalidMoveException {

	private static final long serialVersionUID = -7901379657023895628L;

	public NullFromFieldException() {
		super("Square from is null!");
	}

	public NullFromFieldException(String message) {
		super("ISquare from is null! " + message);
	}
}
