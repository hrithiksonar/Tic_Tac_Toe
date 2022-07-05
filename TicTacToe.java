package com.monocept.model;

import java.util.ArrayList;
import java.util.Collections;


public class TicTacToe {

	private ArrayList<Integer> abscissa = new ArrayList<Integer>();
	private ArrayList<Integer> ordinate = new ArrayList<Integer>();
	private String playerSign = null;
	private static int SIZE = 3;
	private static String gameBoard[][] = new String[SIZE][SIZE];

	public TicTacToe(String move) {
		this.playerSign = move;
	}

	public static String[][] getGameBoard() {
		return gameBoard;
	}

	public ArrayList<Integer> getAbscissa() {
		return abscissa;
	}

	public ArrayList<Integer> getOrdinate() {
		return ordinate;
	}

	public static int getSIZE() {
		return SIZE;
	}

	public String getMove() {
		return playerSign;
	}

	public void insertMove(int xPosition, int yPosition) {
		gameBoard[xPosition - 1][yPosition - 1] = this.playerSign;

	}

	public boolean winner() {
		int diagonal1 = 0, diagonal2 = 0;
		for (int i = 0; i < abscissa.size(); i++) {
			if (Collections.frequency(abscissa, abscissa.get(i)) == SIZE) {
				return true;
			}
			if (Collections.frequency(ordinate, ordinate.get(i)) == SIZE) {
				return true;
			}
			if (abscissa.get(i) == ordinate.get(i)) {
				diagonal1++;
			}
			if ((abscissa.get(i) + ordinate.get(i)) == SIZE + 1) {
				diagonal2++;
			}
		}
		if (diagonal1 == SIZE || diagonal2 == SIZE) {
			return true;
		}
		return false;

	}

	public boolean checkPosition(int xPosition, int yPosition) {
		if (gameBoard[xPosition - 1][yPosition - 1] != "X" && gameBoard[xPosition - 1][yPosition - 1] != "O") {
			this.abscissa.add(xPosition);
			this.ordinate.add(yPosition);
			return true;
		}
		return false;

	}

}
