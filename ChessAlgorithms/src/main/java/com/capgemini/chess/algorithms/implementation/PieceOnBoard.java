package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

/**
 * Interfejs dla klas reprezentuj�cych typ figur na planszy
 * 
 * @author MRATAJCZ
 *
 */
public interface PieceOnBoard {
	/**
	 * Metoda sprawdzaj�ca mo�liwo�� doj�cia wybran� bierk� z pola FROM do TO
	 * 
	 * @param from
	 * @param to
	 * @param board
	 * @return
	 */

	public boolean isPathPossible(Coordinate from, Coordinate to, Board board);

}
