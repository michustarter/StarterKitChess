package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.OccupiedFieldException;

public class Bishop implements PieceOnBoard {

	@Override
	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {
		/*
		 * w Rook tego nie musia�em uwzgl�dnia� ale tutaj mog� wyj�� poza
		 * plansze iteruj�c po �ciezce (tam nie, bo jak kt�raz z x lub y bylo
		 * rownie TO to na bank trafi�o na pole docelowe w koncu bez wyj�cia
		 * poza plansz�) ale w sumie punkt TO musi by� w planszy wi�c to nie ma
		 * znaczenia bo jednak nie wyjdzie poza plansz� !!!
		 */
		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isPossibility = false;

		if (xFrom <= xTo) {
			int i = 0;
			if (yFrom <= yTo) { // tu juz musi by� = bo w koncu yF osi�gnie yTo
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
