package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.OccupiedFieldException;

public class Queen implements PieceOnBoard {

	@Override
	public void determinePath(Coordinate from, Coordinate to, Board board) throws InvalidMoveException {

		// pol¹czone IFY z GONCA - bishop I WIEZY- rook, zakonczone elsem
		// invalid move :)
		int yFrom = from.getY();
		int xFrom = from.getX();
		int yTo = to.getY();
		int xTo = to.getX();
		Piece movedPiece = board.getPieceAt(from);
		/* start ROOK */
		if (yFrom == yTo) {
			int i = 0;
			if (xFrom <= xTo) {
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
				while ((xFrom - i) >= xTo) {
					if ((xFrom - i) == xTo) {
						board.setPieceAt(movedPiece, to);
						board.setPieceAt(null, from);
						return;
					}
					if (board.getPieceAt(new Coordinate((xFrom - i), yFrom)) != null) {
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
		}
		/* end ROOK */
		/* start BISHOP */
		if (xFrom <= xTo) {
			int i = 0;
			if (yFrom <= yTo) {
				while (yFrom <= yTo) {
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom + i)) != null) {
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
					if (board.getPieceAt(new Coordinate(xFrom + i, yFrom - i)) != null) {
						throw new OccupiedFieldException();
					}
					if ((xFrom - i == xTo) && (yFrom - i == yTo)) {
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
		}
		/* end BISHOP */
		/* jeœli ani po ruchach Queen ani Bishop - exception */

		else {
			throw new InvalidMoveException();
		}
	}

}
