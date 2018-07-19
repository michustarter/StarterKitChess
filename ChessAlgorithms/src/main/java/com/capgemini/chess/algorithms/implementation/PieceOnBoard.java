package com.capgemini.chess.algorithms.implementation;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;

/**
 * Interfejs dla klas reprezentuj¹cych typ figur na planszy
 * 
 * @author MRATAJCZ
 *
 */
public interface PieceOnBoard {
	/**
	 * Metoda sprawdzaj¹ca mo¿liwoœæ dojœcia wybran¹ bierk¹ z pola FROM do TO
	 * 
	 * @param from
	 * @param to
	 * @param board
	 * @return
	 */

	public boolean isPathPossible(Coordinate from, Coordinate to, Board board);

}
