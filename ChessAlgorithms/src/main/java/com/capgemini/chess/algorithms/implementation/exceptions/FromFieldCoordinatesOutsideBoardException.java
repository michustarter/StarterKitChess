package com.capgemini.chess.algorithms.implementation.exceptions;
/*
 * Exception thrown in case the coordinates of field from are outside of board
 */

public class FromFieldCoordinatesOutsideBoardException extends InvalidMoveException {

	private static final long serialVersionUID = -3106688561649242422L;

	public FromFieldCoordinatesOutsideBoardException() {
		super("Coordinates of field from are outside the board!");
	}

	public FromFieldCoordinatesOutsideBoardException(String message) {
		super("Coordinates of field from are outside the board!" + message);
	}
}
