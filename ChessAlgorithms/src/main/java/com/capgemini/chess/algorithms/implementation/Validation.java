package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.EqualFieldCoordinatesException;
import com.capgemini.chess.algorithms.implementation.exceptions.FromFieldCoordinatesOutsideBoardException;
import com.capgemini.chess.algorithms.implementation.exceptions.NullFromFieldException;
import com.capgemini.chess.algorithms.implementation.exceptions.ToFieldCoordinatesOutsideBoardException;
import com.capgemini.chess.algorithms.implementation.exceptions.WrongPieceColorAtToFieldException;

public class Validation {

	public boolean basicValidation(Coordinate from, Coordinate to, Board board) {

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		Piece pieceAtTo = board.getPieceAt(to);
		Piece pieceAtFrom = board.getPieceAt(from);
		boolean possibleMove = false;
		boolean rangeInFromField = yFrom >= 0 && yFrom < Board.SIZE && xFrom >= 0 && xFrom < Board.SIZE;
		boolean rangeInToField = yTo >= 0 && yTo < Board.SIZE && xTo >= 0 && xTo < Board.SIZE;

		try {
			if (!rangeInFromField) {
				throw new FromFieldCoordinatesOutsideBoardException();
			}
			if (!rangeInToField) {
				throw new ToFieldCoordinatesOutsideBoardException();
			}
			if (pieceAtFrom == null) {
				throw new NullFromFieldException();
			}
			if (from.equals(to)) {
				throw new EqualFieldCoordinatesException();
			}
			if (pieceAtFrom.getColor() == pieceAtTo.getColor()) {
				throw new WrongPieceColorAtToFieldException();
			}
			possibleMove = true;
		}
		catch (FromFieldCoordinatesOutsideBoardException e) {
			e.printStackTrace();
		} catch (ToFieldCoordinatesOutsideBoardException e) {
			e.printStackTrace();
		} catch (NullFromFieldException e) {
			e.printStackTrace();
		} catch (EqualFieldCoordinatesException e) {
			e.printStackTrace();
		} catch (WrongPieceColorAtToFieldException e) {
			e.printStackTrace();
		}
		return possibleMove;
	}
}
