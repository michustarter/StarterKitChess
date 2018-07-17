package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.OccupiedFieldException;

public class Rook implements PieceOnBoard {

	@Override
	public void determinePath(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		// FIXME - rozwazyæ typ meotdy !!

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		Piece movedPiece = board.getPieceAt(from); // pobieram juz konkretna
													// Wieze - Bia³a lub Czarn¹
		/*
		 * daæ ELSE bo jeœli yTo/xTo bêdize rózne to znaczy ze nie jest punkt w
		 * linii prostej wiêc siê nie da dojsc w danym ruchu do konkretnego celu
		 * - w innych figurach tez to uwzglêdniæ !!
		 */
		if (yFrom == yTo) {
			int i = 0;
			if (xFrom <= xTo) { /*
								 * musi byæ <= a nie samo < bo iteracja musi
								 * dojœæ do pola xTo !!
								 */
				while ((xFrom + i) <= xTo) {
					if ((xFrom + i) == xTo) {
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
						return;
					}
					if (board.getPieceAt(new Coordinate((xFrom + i), yFrom)) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}
			} else if (xFrom >= xTo) {
				/*
				 * musze daæ else IF bo bez IF sprawdzi³oby mi iteracjê dla
				 * xFrom<xTo
				 */
				while ((xFrom - i) >= xTo) {
					if ((xFrom - i) == xTo) {
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
						return;
					}
					if (board.getPieceAt(new Coordinate((xFrom - i), yFrom)) != null) {
						// tutaj jak dojdzie do TO i pole jest zajete przez
						// przeciwnika to robi bicie / a null - attack zwyk³y,
						// jakoœ to rozpisaæ sobie
						throw new OccupiedFieldException();
					}
					i++;
				}
			}
		}

		if (xFrom == xTo) {
			int i = 0;
			if (yFrom <= yTo) {
				while ((yFrom + i) <= yTo) {
					if ((yFrom + i) == yTo) {
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
						return;
					}
					if (board.getPieceAt(new Coordinate(xFrom, (yFrom + i))) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}

			} else if (yFrom >= yTo) {
				while ((yFrom - i) >= yTo) {
					if ((yFrom - i) == yTo) {
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
						return;
					}
					if (board.getPieceAt(new Coordinate(xFrom, (yFrom - i))) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}

			}

		} else {
			throw new InvalidMoveException();
		}

	}
}
