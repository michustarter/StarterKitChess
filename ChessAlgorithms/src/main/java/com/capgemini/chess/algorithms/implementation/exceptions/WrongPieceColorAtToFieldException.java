package com.capgemini.chess.algorithms.implementation.exceptions;

/**
 * Exception thrown in case the piece color at field to is the same as color at
 * field from
 */

public class WrongPieceColorAtToFieldException extends InvalidMoveException {

	private static final long serialVersionUID = 423284614398322784L;

	public WrongPieceColorAtToFieldException() {
		super("Piece color at the field to is the same as field from");
	}

	public WrongPieceColorAtToFieldException(String message) {
		super("Piece color at the field to is the same as field from" + message);
	}
}