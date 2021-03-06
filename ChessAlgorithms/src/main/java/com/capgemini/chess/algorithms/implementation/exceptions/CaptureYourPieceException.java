package com.capgemini.chess.algorithms.implementation.exceptions;

/**
 * Exception thrown in case the piece color at field from is the same as color
 * at field to
 */

public class CaptureYourPieceException extends InvalidMoveException {

	private static final long serialVersionUID = -2705935190062023019L;

	public CaptureYourPieceException() {
		super("Field To has piece in your color");
	}
}