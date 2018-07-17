package com.capgemini.chess.algorithms.implementation.exceptions;

/**
 * Exception thrown in case the piece color at field to is the same as color at
 * field from
 */

public class WrongPieceColorAtToFieldException extends InvalidMoveException {

	private static final long serialVersionUID = -6576123144524039196L;

	public WrongPieceColorAtToFieldException() {
	}
}