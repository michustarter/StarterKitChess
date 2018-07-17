package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.OccupiedFieldException;

public class Rook implements PieceOnBoard {

	@Override
	public boolean isMoveToDestination(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		boolean isPossibility = false;
		/*
		 * da� ELSE bo je�li yTo/xTo b�dize r�zne to znaczy ze nie jest punkt w
		 * linii prostej wi�c si� nie da dojsc w danym ruchu do konkretnego celu
		 * - w innych figurach tez to uwzgl�dni� !!
		 */
		if (yFrom == yTo) {
			int i = 0;
			if (xFrom <= xTo) { /*
								 * musi by� <= a nie samo < bo iteracja musi
								 * doj�� do pola xTo !!
								 */
				while ((xFrom + i) <= xTo) {
					if ((xFrom + i) == xTo) {
						isPossibility=true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate((xFrom + i), yFrom)) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}
			} else if (xFrom >= xTo) {
				/*
				 * musze da� else IF bo bez IF sprawdzi�oby mi iteracj� dla
				 * xFrom<xTo
				 */
				while ((xFrom - i) >= xTo) {
					if ((xFrom - i) == xTo) {
						isPossibility=true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate((xFrom - i), yFrom)) != null) {
						// tutaj jak dojdzie do TO i pole jest zajete przez
						// przeciwnika to robi bicie / a null - attack zwyk�y,
						// jako� to rozpisa� sobie
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
						isPossibility=true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom, (yFrom + i))) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}

			} else if (yFrom >= yTo) {
				while ((yFrom - i) >= yTo) {
					if ((yFrom - i) == yTo) {
						isPossibility=true;
						return isPossibility;
					}
					if (board.getPieceAt(new Coordinate(xFrom, (yFrom - i))) != null) {
						throw new OccupiedFieldException();
					}
					i++;
				}

			}

		} 
		return isPossibility;
		}
	}
