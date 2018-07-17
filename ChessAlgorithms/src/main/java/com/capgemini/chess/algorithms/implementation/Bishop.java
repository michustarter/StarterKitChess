package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.OccupiedFieldException;

public class Bishop implements PieceOnBoard {

	@Override
	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {
		/*
		 * w Rook tego nie musia³em uwzglêdniaæ ale tutaj mogê wyjœæ poza
		 * plansze iteruj¹c po œciezce (tam nie, bo jak któraz z x lub y bylo
		 * rownie TO to na bank trafi³o na pole docelowe w koncu bez wyjœcia
		 * poza planszê) ale w sumie punkt TO musi byæ w planszy wiêc to nie ma
		 * znaczenia bo jednak nie wyjdzie poza planszê !!!
		 */
		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isPossibility = false;

		if (xFrom <= xTo) {
			int i = 0;
			if (yFrom <= yTo) { // tu juz musi byæ = bo w koncu yF osi¹gnie yTo
				while (yFrom <= yTo) {
					if ((xFrom + i == xTo) && (yFrom + i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom + i)) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}
			} else if (yFrom >= yTo) {
				while (yFrom >= yTo) {
					if ((xFrom + i == xTo) && (yFrom - i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom - i)) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}
			}
		}
		if (xFrom >= xTo) {
			int i = 0;
			if (yFrom <= yTo) {
				while (yFrom <= yTo) {
					if ((xFrom - i == xTo) && (yFrom + i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom - i, yFrom + i)) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}
			} else if (yFrom >= yTo) {
				while (yFrom >= yTo) {
					if ((xFrom - i == xTo) && (yFrom - i == yTo)) {
						isPossibility = true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom - i, yFrom - i)) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}
			}
		}
		return isPossibility;
	}
}
