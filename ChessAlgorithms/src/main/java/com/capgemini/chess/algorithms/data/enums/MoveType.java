package com.capgemini.chess.algorithms.data.enums;

/**
 * Types of moves
 * 
 * @author Michal Bejm
 *
 */
public enum MoveType {
	ATTACK, // ruch zwyk³y, konczy sie zmiana pozycji jedynie
	CAPTURE, // bicie czyli przejecie kogos pionka
	CASTLING, //roszada
	EN_PASSANT; //bicie w przelocie
}
