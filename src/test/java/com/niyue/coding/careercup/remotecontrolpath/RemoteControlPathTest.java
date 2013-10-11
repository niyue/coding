package com.niyue.coding.careercup.remotecontrolpath;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class RemoteControlPathTest {

	@Test
	public void testWidthOne() {
		RemoteControlPath rcp = new RemoteControlPath();
		String keys = rcp.getKeys(1, "bc");
		assertThat(keys, is("d!d!"));
	}
	
	@Test
	public void testWidthOneUpAndDown() {
		RemoteControlPath rcp = new RemoteControlPath();
		String keys = rcp.getKeys(1, "bdc");
		assertThat(keys, is("d!dd!u!"));
	}
	
	@Test
	public void testWidthTwoUpAndDown() {
		RemoteControlPath rcp = new RemoteControlPath();
		String keys = rcp.getKeys(2, "bdc");
		assertThat(keys, is("r!d!l!"));
	}
	
	@Test
	public void testWidthFiveSample() {
		RemoteControlPath rcp = new RemoteControlPath();
		String keys = rcp.getKeys(5, "up");
		assertThat(keys, is("dddd!u!"));
	}
	
	@Test
	public void testWidthLastRow() {
		RemoteControlPath rcp = new RemoteControlPath();
		String keys = rcp.getKeys(5, "yzy");
		assertThat(keys, is("ddddrrrr!dllll!urrrr!"));
	}

}
