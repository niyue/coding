package com.niyue.coding.careercup.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// http://www.careercup.com/question?id=6239893
// http://www.jesperjuul.net/ludologist/255168-ways-of-playing-tic-tac-toe
public class TicTacToeMoves {
	private int[] rows = new int[3];
	private int[] cols = new int[3];
	private int[] dias = new int[2];
	private static final int WIDTH = 3;
	private static final int WIN = WIDTH;
	private List<List<int[]>> allMoves;
	
	public List<List<int[]>> allMoves() {
		allMoves = new ArrayList<List<int[]>>();
		allMoves(new ArrayList<int[]>(), new HashSet<int[]>(Arrays.asList(
				new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}, 
				new int[]{0, 1}, new int[]{1, 1}, new int[]{2, 1},
				new int[]{0, 2}, new int[]{1, 2}, new int[]{2, 2}
		)));
		return allMoves;
	}
	
	private void allMoves(List<int[]> moves, Set<int[]> remainingCells) {
		for(int[] move : new ArrayList<int[]>(remainingCells)) {
			move(move, moves, remainingCells);
			if(Math.abs(rows[move[0]]) == WIN || Math.abs(cols[move[1]]) == WIN || Math.abs(dias[0]) == WIN || Math.abs(dias[1]) == WIN || moves.size() == WIDTH * WIDTH) {
				allMoves.add(Collections.unmodifiableList(moves));
			} else {
				allMoves(moves, remainingCells);
			}
			unmove(move, moves, remainingCells);
		}
	}

	private void move(int[] move, List<int[]> moves, Set<int[]> remainingCells) {
		int player = moves.size() % 2 == 0 ? 1 : -1;
		rows[move[0]] += player;
		cols[move[1]] += player;
		if(move[0] == move[1]) {
			dias[0] += player;
		}
		if(move[0] + move[1] == WIDTH - 1) {
			dias[1] += player;
		}
		remainingCells.remove(move);
		moves.add(move);
	}
	
	private void unmove(int[] move, List<int[]> moves, Set<int[]> remainingCells) {
		moves.remove(move);
		remainingCells.add(move);
		int player = moves.size() % 2 == 0 ? 1 : -1;
		rows[move[0]] -= player;
		cols[move[1]] -= player;
		if(move[0] == move[1]) {
			dias[0] -= player;
		}
		if(move[0] + move[1] == WIDTH - 1) {
			dias[1] -= player;
		}
	}
}
