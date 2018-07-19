package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.EqualFieldsCoordinatesException;
import com.capgemini.chess.algorithms.implementation.exceptions.FromFieldCoordinatesOutsideBoardException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.NullFromFieldException;
import com.capgemini.chess.algorithms.implementation.exceptions.CaptureYourPieceException;
import com.capgemini.chess.algorithms.implementation.exceptions.ToFieldCoordinatesOutsideBoardException;

public class Validation {
	/**
	 * co robi metodaaa opisa�
	 * 
	 * @param from
	 * @param to
	 * @param board
	 * @throws InvalidMoveException
	 */
	public static void basicValidation(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isRangeFromField = yFrom >= 0 && yFrom < Board.SIZE && xFrom >= 0 && xFrom < Board.SIZE;
		boolean isRangeToField = yTo >= 0 && yTo < Board.SIZE && xTo >= 0 && xTo < Board.SIZE;

		if (!isRangeFromField) {
			throw new FromFieldCoordinatesOutsideBoardException();
		}
		if (!isRangeToField) {
			throw new ToFieldCoordinatesOutsideBoardException();
		}
		if (board.getPieceAt(from) == null) {
			throw new NullFromFieldException();
		}
		if (from.equals(to)) {
			throw new EqualFieldsCoordinatesException();
		}
		if (board.getPieceAt(to) != null && (board.getPieceAt(to).getColor() == board.getPieceAt(from).getColor())) {
			throw new CaptureYourPieceException();
		}
	}
}
