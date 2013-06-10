package com.niyue.coding.careercup.shuffledwords;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.AnyOf.anyOf;
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
	
	@Test
	public void testMoreWordsWithoutShuffled() {
		ShuffledWords sw = new ShuffledWords();
		String sentence = sw.restore("iamastudentfromwaterloo", ImmutableSet.of("from", "waterloo", "hi", "am", "yes", "i", "a", "student"));
		assertThat(sentence, anyOf(is("i am a student from waterloo"), is("i a am student from waterloo")));
	}
}
