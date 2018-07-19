package com.capgemini.chess.algorithms.implementation.exceptions;
/*
 * Exception thrown in case the coordinates of field to are outside of board
 */

public class ToFieldCoordinatesOutsideBoardException extends InvalidMoveException {

	private static final long serialVersionUID = -2697173672721540908L;

	public ToFieldCoordinatesOutsideBoardException() {
		super("Coordinates of field To are outside the board!");
	}
}
