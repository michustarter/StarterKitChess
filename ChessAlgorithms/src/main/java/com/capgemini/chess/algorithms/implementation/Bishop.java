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
		Piece movedPiece = board.getPieceAt(from);

		if (xFrom <= xTo) { // nie musi byæ <>= bo nigdy nie bêdzie to po tym
							// samym X na bank
			int i = 0;
			if (yFrom <= yTo) { // tu juz musi byæ = bo w koncu yF osi¹gnie yTo
				while (yFrom <= yTo) {
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom + i)) != null) {
						throw new OccupiedFieldException();
					}

					if ((xFrom + i == xTo) && (yFrom + i == yTo)) {
						/*
						 * sprawdzenie czy inny kolor tam jest niz ruszany
						 * pionek juz w Validation by³o
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
						 * wczeœniej
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
