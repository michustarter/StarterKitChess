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
	 * Metoda sprawdza 5 podstawowych warunków, które musz¹ zostaæ spe³nione, by
	 * mo¿na by³o rozpatrzeæ dalsze mo¿liwoœci wykonywania ruchu: 
	 * 1. Czy pole FROM znajduje siê na planszy 2. Czy pole TO znajduje siê na  planszy 
	 * 3. Czy na polu FROM jest jakaœ bierka 
	 * 4. Czy pole TO nie jest równe polu FROM 
	 * 5. Czy kolor bierki na polu TO jest ró¿ny od koloru na polu FROM
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
