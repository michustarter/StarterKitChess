package com.capgemini.chess.algorithms.implementation.exceptions;
/*
 * Exception thrown in case the iteration on the next fields to the To field will meet the occupied field along the way
 */

public class OccupiedFieldException extends InvalidMoveException {

	private static final long serialVersionUID = 2006918001959196954L;

	public OccupiedFieldException() {
		super("The path to get to the To field contains an obstacle!");
	}

	public OccupiedFieldException(String message) {
		super("The path to get to the TO field contains an obstacle" + message);
	}
}
