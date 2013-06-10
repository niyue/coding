package com.niyue.coding.careercup.shuffledwords;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.google.common.collect.ImmutableSet;

public class ShuffledWordsTest {
	@Test
	public void testOneWordWithoutShuffled() {
		ShuffledWords sw = new ShuffledWords();
		String sentence = sw.restore("word", ImmutableSet.of("word"));
		assertThat(sentence, is("word"));
	}
	
	@Test
	public void testThreeWords() {
		ShuffledWords sw = new ShuffledWords();
		String sentence = sw.restore("swordaerheldfsfu", ImmutableSet.of("words", "are", "shuffled"));
		assertThat(sentence, is("words are shuffled"));
	}

}
