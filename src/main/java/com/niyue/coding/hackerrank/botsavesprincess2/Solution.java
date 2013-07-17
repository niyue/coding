package com.niyue.coding.hackerrank.botsavesprincess2;

import java.util.Scanner;

// https://www.hackerrank.com/challenges/saveprincess2
public class Solution {
	private static int[] p = new int[2];

	static void nextMove(int n, int x, int y, String[] board) {
		String move = null;
		if (p[0] != x) {
			move = p[0] < x ? "UP" : "DOWN";
		} else {
			if (p[1] != y) {
				move = p[1] < y ? "LEFT" : "RIGHT";
			}
		}
		if (move != null) {
			System.out.print(move);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n, x, y;
		n = in.nextInt();
		x = in.nextInt();
		y = in.nextInt();
		in.useDelimiter("\n");
		String board[] = new String[n];

		for (int i = 0; i < n; i++) {
			board[i] = in.next();
			int py = board[i].indexOf('p');
			if (py != -1) {
				p[0] = i;
				p[1] = py;
			}
		}
		in.close();
		nextMove(n, x, y, board);
	}
}
