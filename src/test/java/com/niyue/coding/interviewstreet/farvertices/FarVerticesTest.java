package com.niyue.coding.interviewstreet.farvertices;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class FarVerticesTest {
	private ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() throws FileNotFoundException {
	    System.setOut(new PrintStream(output));
	    InputStream input = this.getClass().getResourceAsStream("data.txt");
	    System.setIn(input);
	}
	
	@Test
	public void test() throws Exception {
		Solution sl = new Solution();
        sl.solve();
        assertEquals("4", output.toString().trim());
	}
}
