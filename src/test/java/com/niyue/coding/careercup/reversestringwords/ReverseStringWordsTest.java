package com.niyue.coding.careercup.reversestringwords;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class ReverseStringWordsTest {

	@Test
	public void testOneWord() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("001");
		assertThat(reversed, is("001"));
	}
	
	@Test
	public void testMultipleSpaces() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("001  002");
		assertThat(reversed, is("002  001"));
	}
	
	@Test
	public void testTrailingSpace() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("001  ");
		assertThat(reversed, is("  001"));
	}
	
	@Test
	public void testTwoWordsTrailingSpace() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("001 002  ");
		assertThat(reversed, is("  002 001"));
	}
	
	@Test
	public void testMultipleWords() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("My name is X Y Z");
		assertThat(reversed, is("Z Y X is name My"));
	}
	
	@Test
	public void testLeadingSpace() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("  001");
		assertThat(reversed, is("001  "));
	}
	
	@Test
	public void testLeadingSpacesTwoWords() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("  001 002");
		assertThat(reversed, is("002 001  "));
	}
	
	@Test
	public void testTabAsWhiteSpace() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("001	002");
		assertThat(reversed, is("002	001"));
	}
	
	@Test
	public void testLongerWords() {
		ReverseStringWords rev = new ReverseStringWords();
		String reversed = rev.reverse("These pretzels are making me thirsty");
		assertThat(reversed, is("thirsty me making are pretzels These"));
	}
}
