package com.monocept.test;

import java.util.Scanner;
import com.monocept.model.TicTacToe;

public class TicTacToeTest {

	public static void printLoop2(int i, String game[][]) {

		for (int j = 0; j < TicTacToe.getSIZE(); j++) {
			if (game[i][j] != null)
				System.out.print("   " + game[i][j] + "	");
			else
				System.out.print("   	");
			if (j == TicTacToe.getSIZE() - 1) {
				continue;
			}
			System.out.print("|");
		}

	}

	public static void printLoop1(String game[][]) {
		for (int i = 0; i < TicTacToe.getSIZE(); i++) {
			printLoop2(i, game);
			if (i != TicTacToe.getSIZE() - 1)
				System.out.println("\n--------------------------");
		}
		System.out.println("\n");
	}

	public static void play(TicTacToe player) {
		Scanner scan = new Scanner(System.in);
		System.out.printf("Player '%s', enter your move (row[1-3] column[1-3]): ", player.getMove());
		int rowChoice = scan.nextInt();
		int columnChoice = scan.nextInt();
		if (player.checkPosition(rowChoice, columnChoice)) {
			player.insertMove(rowChoice, columnChoice);
		} else {
			System.out.printf("This move at (%d,%d) is not valid. Try again...\n", rowChoice, columnChoice);
			play(player);
		}

	}

	public static void checkWin(TicTacToe player) {
		if (player.winner()) {
			System.out.printf("Player '%s' won!", player.getMove());
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		int count = 0;
		TicTacToe playerX = new TicTacToe("X");
		TicTacToe playerO = new TicTacToe("O");
		Scanner scan = new Scanner(System.in);
		while (true) {
			play(playerX);
			printLoop1(TicTacToe.getGameBoard());
			checkWin(playerX);

			count++;

			if (count == 9) {
				break;
			}

			play(playerO);
			printLoop1(TicTacToe.getGameBoard());
			checkWin(playerO);
			count++;

		}
		System.out.println("IT'S A DRAW");
	}

}
