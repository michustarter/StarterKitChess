package com.capgemini.chess.algorithms.implementation.exceptions;
/*
 * Exception thrown in case the coordinates of field from and to are equal
 */

public class EqualFieldCoordinatesException extends InvalidMoveException {

	private static final long serialVersionUID = -4482440433453877973L;

	public EqualFieldCoordinatesException() {
		super("Coordinates of fields from and to are equal!");
	}

	public EqualFieldCoordinatesException(String message) {
		super("Coordinates of fields from and to are equal!" + message);
	}
}
