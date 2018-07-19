package com.capgemini.chess.algorithms.implementation.exceptions;

/**
 * Exception thrown in case the chosen chessboard fiels is null and does not
 * have any Piece
 */

public class NullFromFieldException extends InvalidMoveException {

	private static final long serialVersionUID = 673830064026336541L;

	public NullFromFieldException() {
		super("From field is null");

	}

}
