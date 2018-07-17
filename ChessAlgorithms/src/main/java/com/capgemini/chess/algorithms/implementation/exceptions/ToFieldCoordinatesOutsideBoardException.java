package com.capgemini.chess.algorithms.implementation.exceptions;
/*
 * Exception thrown in case the coordinates of field to are outside of board
 */

public class ToFieldCoordinatesOutsideBoardException extends InvalidMoveException {

	private static final long serialVersionUID = -3106688561649242422L;

	public ToFieldCoordinatesOutsideBoardException() {
		super("Coordinates of field to are outside the board!");
	}

	public ToFieldCoordinatesOutsideBoardException(String message) {
		super("Coordinates of field to are outside the board!" + message);
	}
}
