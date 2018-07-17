package com.capgemini.chess.algorithms.implementation.exceptions;
/*
 * Exception thrown in case the iteration on the next fields to the To field will meet the occupied field along the way
 */

public class OccupiedFieldException extends InvalidMoveException {

	private static final long serialVersionUID = 709351584731396904L;

	public OccupiedFieldException() {
	}
}
