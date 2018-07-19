package com.capgemini.chess.algorithms.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.KingInCheckException;

public class BoardManager {

	private Board board = new Board();

	public BoardManager() {
		initBoard();
	}

	public BoardManager(List<Move> moves) {
		initBoard();
		for (Move move : moves) {
			addMove(move);
		}
	}

	public BoardManager(Board board) {
		this.board = board;
	}

	/**
	 * Getter for generated board
	 *
	 * @return board
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * Performs move of the chess piece on the chess board from one field to
	 * another.
	 *
	 * @param from
	 *            coordinates of 'from' field
	 * @param to
	 *            coordinates of 'to' field
	 * @return move object which includes moved piece and move type
	 * @throws InvalidMoveException
	 *             in case move is not valid
	 */
	public Move performMove(Coordinate from, Coordinate to) throws InvalidMoveException {

		Move move = validateMove(from, to);

		addMove(move);

		return move;
	}

	/**
	 * Calculates state of the chess board.
	 *
	 * @return state of the chess board
	 */
	public BoardState updateBoardState() {

		Color nextMoveColor = calculateNextMoveColor();

		boolean isKingInCheck = isKingInCheck(nextMoveColor);
		boolean isAnyMoveValid = isAnyMoveValid(nextMoveColor);

		BoardState boardState;
		if (isKingInCheck) {
			if (isAnyMoveValid) {
				boardState = BoardState.CHECK;
			} else {
				boardState = BoardState.CHECK_MATE;
			}
		} else {
			if (isAnyMoveValid) {
				boardState = BoardState.REGULAR;
			} else {
				boardState = BoardState.STALE_MATE;
			}
		}
		this.board.setState(boardState);
		return boardState;
	}

	/**
	 * Checks threefold repetition rule (one of the conditions to end the chess
	 * game with a draw). // remisem
	 *
	 * @return true if current state repeated at list two times, false otherwise
	 */
	public boolean checkThreefoldRepetitionRule() {

		// there is no need to check moves that where before last capture/en
		// passant/castling
		int lastNonAttackMoveIndex = findLastNonAttackMoveIndex();
		List<Move> omittedMoves = this.board.getMoveHistory().subList(0, lastNonAttackMoveIndex);
		BoardManager simulatedBoardManager = new BoardManager(omittedMoves);

		int counter = 0;
		for (int i = lastNonAttackMoveIndex; i < this.board.getMoveHistory().size(); i++) {
			Move moveToAdd = this.board.getMoveHistory().get(i);
			simulatedBoardManager.addMove(moveToAdd);
			boolean areBoardsEqual = Arrays.deepEquals(this.board.getPieces(),
					simulatedBoardManager.getBoard().getPieces());
			if (areBoardsEqual) {
				counter++;
			}
		}

		return counter >= 2;
	}

	/**
	 * Checks 50-move rule (one of the conditions to end the chess game with a
	 * draw).
	 *
	 * @return true if no pawn was moved or not capture was performed during
	 *         last 50 moves, false otherwise
	 */
	public boolean checkFiftyMoveRule() {

		// for this purpose a "move" consists of a player completing his turn
		// followed by his opponent completing his turn
		if (this.board.getMoveHistory().size() < 100) {
			return false;
		}

		for (int i = this.board.getMoveHistory().size() - 1; i >= this.board.getMoveHistory().size() - 100; i--) {
			Move currentMove = this.board.getMoveHistory().get(i);
			PieceType currentPieceType = currentMove.getMovedPiece().getType();
			if (currentMove.getType() != MoveType.ATTACK || currentPieceType == PieceType.PAWN) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Metoda szuka Króla na planszy o kolorze przekazanym jako parametr
	 * 
	 * @param kingColor
	 * @return
	 * @throws NullPointerException
	 */
	public Coordinate lookForKing(Color kingColor) throws NullPointerException {
		int x = 0;
		int y = 0;
		Piece wantedKing;
		Coordinate found = new Coordinate(x, y);

		while (y < Board.SIZE) {
			while (x < Board.SIZE) {
				found = new Coordinate(x, y);
				wantedKing = board.getPieceAt(found);
				if (wantedKing != null && wantedKing.getType() == PieceType.KING
						&& wantedKing.getColor() == kingColor) {
					return found;
				}
				x++;
			}
			x = 0;
			y++;
		}
		return found;
	}
	// PRIVATE

	private void initBoard() {

		this.board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(0, 7));
		this.board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(1, 7));
		this.board.setPieceAt(Piece.BLACK_BISHOP, new Coordinate(2, 7));
		this.board.setPieceAt(Piece.BLACK_QUEEN, new Coordinate(3, 7));
		this.board.setPieceAt(Piece.BLACK_KING, new Coordinate(4, 7));
		this.board.setPieceAt(Piece.BLACK_BISHOP, new Coordinate(5, 7));
		this.board.setPieceAt(Piece.BLACK_KNIGHT, new Coordinate(6, 7));
		this.board.setPieceAt(Piece.BLACK_ROOK, new Coordinate(7, 7));

		for (int x = 0; x < Board.SIZE; x++) {
			this.board.setPieceAt(Piece.BLACK_PAWN, new Coordinate(x, 6));
		}

		this.board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(0, 0));
		this.board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(1, 0));
		this.board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(2, 0));
		this.board.setPieceAt(Piece.WHITE_QUEEN, new Coordinate(3, 0));
		this.board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
		this.board.setPieceAt(Piece.WHITE_BISHOP, new Coordinate(5, 0));
		this.board.setPieceAt(Piece.WHITE_KNIGHT, new Coordinate(6, 0));
		this.board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(7, 0));

		for (int x = 0; x < Board.SIZE; x++) {
			this.board.setPieceAt(Piece.WHITE_PAWN, new Coordinate(x, 1));
		}
	}

	private void addMove(Move move) {

		addRegularMove(move);

		if (move.getType() == MoveType.CASTLING) {
			addCastling(move);
		} else if (move.getType() == MoveType.EN_PASSANT) {
			addEnPassant(move);
		}

		this.board.getMoveHistory().add(move);
	}

	private void addRegularMove(Move move) {
		Piece movedPiece = this.board.getPieceAt(move.getFrom());
		this.board.setPieceAt(null, move.getFrom());
		this.board.setPieceAt(movedPiece, move.getTo());

		performPromotion(move, movedPiece);
	}

	private void performPromotion(Move move, Piece movedPiece) {
		if (movedPiece == Piece.WHITE_PAWN && move.getTo().getY() == (Board.SIZE - 1)) {
			this.board.setPieceAt(Piece.WHITE_QUEEN, move.getTo());
		}
		if (movedPiece == Piece.BLACK_PAWN && move.getTo().getY() == 0) {
			this.board.setPieceAt(Piece.BLACK_QUEEN, move.getTo());
		}
	}

	private void addCastling(Move move) {
		if (move.getFrom().getX() > move.getTo().getX()) {
			Piece rook = this.board.getPieceAt(new Coordinate(0, move.getFrom().getY()));
			this.board.setPieceAt(null, new Coordinate(0, move.getFrom().getY()));
			this.board.setPieceAt(rook, new Coordinate(move.getTo().getX() + 1, move.getTo().getY()));
		} else {
			Piece rook = this.board.getPieceAt(new Coordinate(Board.SIZE - 1, move.getFrom().getY()));
			this.board.setPieceAt(null, new Coordinate(Board.SIZE - 1, move.getFrom().getY()));
			this.board.setPieceAt(rook, new Coordinate(move.getTo().getX() - 1, move.getTo().getY()));
		}
	}

	private void addEnPassant(Move move) {
		Move lastMove = this.board.getMoveHistory().get(this.board.getMoveHistory().size() - 1);
		this.board.setPieceAt(null, lastMove.getTo());
	}

	/**
	 * Walidacja ruchu. Po metodzie determinePath tworzona jest tymczasowa
	 * tablica, która zachowuje obecny stan planszy, a w planszy zapisujê
	 * teoretyczny jej stan po wykonaniu ruchu. Nastêpnie sprawdzam, czy
	 * wykonany ruch nie spowoduje szacha dla mojego Króla; nastêpnie ponownie
	 * do planszy przypisujê jej pierwotny stan; na koñcu ustawiam parametry
	 * wykonanego ruchu i zwracam obiekt typu Move.
	 * 
	 * @param from
	 * @param to
	 * @return
	 * @throws InvalidMoveException
	 * @throws KingInCheckException
	 */
	private Move validateMove(Coordinate from, Coordinate to) throws InvalidMoveException, KingInCheckException {

		Validation.basicValidation(from, to, board);
		Piece movedPiece = board.getPieceAt(from);
		Piece pieceAtTo = board.getPieceAt(to);
		Move executedMove = new Move();

		isMovedColorCorrect(movedPiece);

		determinePath(movedPiece, from, to);

		Board tempBoard = board;
		board.setPieceAt(movedPiece, to);
		board.setPieceAt(null, from);
		//
		if (isKingInCheck(movedPiece.getColor())) {
			throw new KingInCheckException();
		}
		board = tempBoard;

		if (pieceAtTo != null) {
			executedMove.setType(MoveType.CAPTURE);
		} else {
			executedMove.setType(MoveType.ATTACK);
		}
		executedMove.setFrom(from);
		executedMove.setTo(to);
		executedMove.setMovedPiece(movedPiece);

		return executedMove;
	}

	/**
	 * W metodzie dokonuje siê iteracja po ka¿dym polu planszy; jeœli na polu
	 * stoi bierka przeciwnika, dodajê jej wspó³rzêdne do mapy (klucz) i na
	 * podstawie okreœlonego typu przekazujê do mapy (jako wartoœæ) obiekt klasy
	 * reprezentuj¹cej figurê i implementuj¹cej interfejs PieceOnBoard.
	 * 
	 * W drugiej pêtli dla ka¿dej z figur przeciwnika przechowywanej w mapie
	 * sprawdzam mo¿liwoœæ dojœcia do Króla. Jeœli jest taka mo¿liwoœæ, zwracam
	 * true.
	 * 
	 * @param kingColor
	 * @return
	 * @throws NullPointerException
	 */
	private boolean isKingInCheck(Color kingColor) throws NullPointerException {
		int x = 0;
		int y = 0;
		boolean result = false;
		PieceOnBoard checkedPiece;
		Coordinate searched = new Coordinate(x, y);
		Piece found = board.getPieceAt(searched);
		Map<Coordinate, PieceOnBoard> opponentPieces = new HashMap<>();
		while (y < Board.SIZE) {
			while (x < Board.SIZE) {
				searched = new Coordinate(x, y);
				found = board.getPieceAt(searched);
				if (found != null && found.getColor() != kingColor) {
					checkedPiece = PieceFactory.returnPiece(found.getType());
					opponentPieces.put(searched, checkedPiece);
				}
				x++;
			}
			x = 0;
			y++;
		}
		for (Coordinate from : opponentPieces.keySet()) {
			if (opponentPieces.get(from).isPathPossible(from, lookForKing(kingColor), board)) {
				result = true;
				return result;
			}
		}
		return result;
	}

	// FIXME - metoda nie dzia³a poprawnie
	/**
	 * Tworzê nextPiece mapê do której zapisujê po³o¿enie (jako klucz) bierek
	 * gracza w jego kolejce, a jako wartoœc - obiekt klasy reprezentuj¹cej dany
	 * typ figury. Do listy otherFields przekazujê wspó³rzêdne pól pustych oraz
	 * pól, na których stoj¹ bierki przeciwnika; nastêpnie dla ka¿dej z moich
	 * bierek zawartych w mapie nextPiece sprawdzam czy jest mo¿liwe dojœcie do
	 * jakiegolwiek z pól zawartych w liœcie otherFields
	 * 
	 * @param nextMoveColor
	 * @return
	 */
	private boolean isAnyMoveValid(Color nextMoveColor) {

		int x = 0;
		int y = 0;
		Piece wantedPiece;
		boolean result = false;
		PieceOnBoard myPiece;
		Coordinate verified;

		Map<Coordinate, PieceOnBoard> nextPiece = new HashMap<>();
		List<Coordinate> otherFileds = new ArrayList<>();
		while (y < Board.SIZE) {
			while (x < Board.SIZE) {
				verified = new Coordinate(x, y);
				wantedPiece = board.getPieceAt(verified);
				if (wantedPiece != null && wantedPiece.getColor() == nextMoveColor) {
					myPiece = PieceFactory.returnPiece(wantedPiece.getType());
					nextPiece.put(verified, myPiece);
				} else {
					otherFileds.add(verified);
				}
				x++;
			}
			x = 0;
			y++;
		}
		for (Coordinate from : nextPiece.keySet()) {
			for (Coordinate to : otherFileds) {
				if (nextPiece.get(from).isPathPossible(from, to, board) && !isKingInCheck(nextMoveColor)) {
					result = true;
					return result;
				}
			}

		}
		return result;
	}

	private Color calculateNextMoveColor() {
		if (this.board.getMoveHistory().size() % 2 == 0) {
			return Color.WHITE;
		} else {
			return Color.BLACK;
		}
	}

	private int findLastNonAttackMoveIndex() {
		int counter = 0;
		int lastNonAttackMoveIndex = 0;

		for (Move move : this.board.getMoveHistory()) {
			if (move.getType() != MoveType.ATTACK) {
				lastNonAttackMoveIndex = counter;
			}
			counter++;
		}

		return lastNonAttackMoveIndex;
	}

	/**
	 * Metoda sprawdzaj¹ca, czy bierka, któr¹ gracz bêdzie siê poruszaæ, jest
	 * w³aœciwego koloru.
	 * 
	 * @param movedPiece
	 * @throws InvalidMoveException
	 */
	private void isMovedColorCorrect(Piece movedPiece) throws InvalidMoveException {
		if (movedPiece.getColor() != calculateNextMoveColor()) {
			throw new InvalidMoveException();
		}
	}

	/**
	 * W metodzie na podstawie danej bierki, z metody w klasie PieceFactory
	 * wywo³ujê obiekt, który reprezentuje dan¹ figurê - mo¿na wtedy wywo³aæ
	 * metodê okreœlaj¹c¹ mo¿liwoœæ dojœcia do danego pola.
	 * 
	 * @param movedPiece
	 * @param from
	 * @param to
	 * @throws InvalidMoveException
	 */
	private void determinePath(Piece movedPiece, Coordinate from, Coordinate to) throws InvalidMoveException {
		PieceOnBoard chosenPiece;
		chosenPiece = PieceFactory.returnPiece(movedPiece.getType());

		if (!chosenPiece.isPathPossible(from, to, board)) {
			throw new InvalidMoveException();
		}
	}

}
