package com.niyue.coding.careercup.tictactoe;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;

public class TicTacToeMovesTest {

	@Test
	// http://www.jesperjuul.net/ludologist/255168-ways-of-playing-tic-tac-toe
	public void testGetAllMoves() {
		TicTacToeMoves ttt = new TicTacToeMoves();
		List<List<int[]>> allMoves = ttt.allMoves();
		assertThat(allMoves.size(), is(255168));
	}
}
