package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.OccupiedFieldException;

public class Bishop implements PieceOnBoard {

	@Override
	public void determinePath(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {
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
		Piece movedPiece = board.getPieceAt(from);

		if (xFrom <= xTo) { // nie musi by� <>= bo nigdy nie b�dzie to po tym
							// samym X na bank
			int i = 0;
			if (yFrom <= yTo) { // tu juz musi by� = bo w koncu yF osi�gnie yTo
				while (yFrom <= yTo) {
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom + i)) != null) {
						throw new OccupiedFieldException();
					}

					if ((xFrom + i == xTo) && (yFrom + i == yTo)) {
						/*
						 * sprawdzenie czy inny kolor tam jest niz ruszany
						 * pionek juz w Validation by�o
						 */
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
					}
					i++;
				}
			} else if (yFrom >= yTo) {
				while (yFrom >= yTo) {
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom - i)) != null) {
						throw new OccupiedFieldException();
					}
					if ((xFrom - i == xTo) && (yFrom - i == yTo)) {
						/*
						 * spr czy inny kolor tam jest niz ruszany pionek juz
						 * wcze�niej
						 */
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
					}
					i++;
				}
			}
		} /////////// *
		if (xFrom >= xTo) {
			int i = 0;
			if (yFrom <= yTo) {
				while (yFrom <= yTo) {
					if (board.getPieceAt(new Coordinate(xFrom - i, yFrom + i)) != null) {
						throw new OccupiedFieldException();
					}
					if ((xFrom + i == xTo) && (yFrom + i == yTo)) {
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
					}
					i++;
				}
			} else if (yFrom >= yTo) {
				while (yFrom >= yTo) {
					if (board.getPieceAt(new Coordinate(xFrom - i, yFrom - i)) != null) {
						throw new OccupiedFieldException();
					}
					if ((xFrom - i == xTo) && (yFrom - i == yTo)) {
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
					}
					i++;
				}
			}
		} else {
			throw new InvalidMoveException();
		}
	}
}
