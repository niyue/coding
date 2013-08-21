package com.niyue.coding.careercup.tictactoe;

import java.util.ArrayList;
import java.util.List;

// http://www.careercup.com/question?id=6239893
// http://www.jesperjuul.net/ludologist/255168-ways-of-playing-tic-tac-toe
public class TicTacToe {
	private int[] rows = new int[3];
	private int[] cols = new int[3];
	private int[] dias = new int[2];
	private static final int WIDTH = 3;
	private static final int WIN = WIDTH;
	private List<List<Integer>> allMoves;
	private static final int[] rowIndexes = new int[] {0, 0, 0, 1, 1, 1, 2, 2, 2};
	private static final int[] colIndexes = new int[] {0, 1, 2, 0, 1, 2, 0, 1, 2};
	
	public List<List<Integer>> allMoves() {
		allMoves = new ArrayList<List<Integer>>();
		allMoves(new ArrayList<Integer>(), new boolean[9]);
		return allMoves;
	}
	
	private void allMoves(List<Integer> moves, boolean[] cells) {
		for(int i = 0; i < cells.length; i++) {
			if(!cells[i]) {
				move(i, moves, cells);
				if(Math.abs(rows[rowIndexes[i]]) == WIN || 
						Math.abs(cols[colIndexes[i]]) == WIN || 
						Math.abs(dias[0]) == WIN || 
						Math.abs(dias[1]) == WIN || 
						moves.size() == WIDTH * WIDTH) {
					allMoves.add(moves);
				} else {
					allMoves(moves, cells);
				}
				unmove(i, moves, cells);
			}
		}
	}
	
	private void move(int move, List<Integer> moves, boolean[] cells) {
		int player = moves.size() % 2 == 0 ? 1 : -1;
		rows[rowIndexes[move]] += player;
		cols[colIndexes[move]] += player;
		if(rowIndexes[move] == colIndexes[move]) {
			dias[0] += player;
		}
		if(rowIndexes[move] + colIndexes[move] == WIDTH - 1) {
			dias[1] += player;
		}
		cells[move] = true;
		moves.add(move);
	}
	
	private void unmove(int move, List<Integer> moves, boolean[] cells) {
		moves.remove(moves.size() - 1);
		cells[move] = false;
		int player = moves.size() % 2 == 0 ? 1 : -1;
		rows[rowIndexes[move]] -= player;
		cols[colIndexes[move]] -= player;
		if(rowIndexes[move] == colIndexes[move]) {
			dias[0] -= player;
		}
		if(rowIndexes[move] + colIndexes[move] == WIDTH - 1) {
			dias[1] -= player;
		}
	}
}
