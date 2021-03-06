package com.niyue.coding.careercup.ctrlctrcv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// http://www.careercup.com/question?id=7184083
// TODO: DP solution without too many base cases and assumptions
// http://stackoverflow.com/questions/4606984/maximum-number-of-characters-using-keystrokes-a-ctrla-ctrlc-and-ctrlv
// http://leetcode.com/2011/01/ctrla-ctrlc-ctrlv.html
public class CtrlcCtrlv {
	public PressingResult press(int n) {
		PressingResult result = press(n, 0, 0);
		Collections.reverse(result.keystrokes);
		return result;
	}
	
	private PressingResult press(int n, long clipboard, long notepad) {
		PressingResult result = null;
		if(n < 0) {
			result = new PressingResult(new ArrayList<String>(), -1);
		} else if(n == 0) {
			result = new PressingResult(new ArrayList<String>(), notepad);
		} else {
			PressingResult pressAResult = press(n - 1, clipboard, notepad + 1);
			press(pressAResult, "A");
			
			PressingResult pressCtrlVResult = press(n - 1, clipboard, notepad + clipboard);
			press(pressCtrlVResult, "CtrlV");
			
			PressingResult pressComboResult = press(n - 4, notepad, notepad * 2);
			press(pressComboResult, "CtrlV", "CtrlV", "CtrlC", "CtrlA");
			
			result = max(pressAResult, max(pressCtrlVResult, pressComboResult));
		}
		return result;
	}
	
	private void press(PressingResult result, String... keystroke) {
		result.keystrokes.addAll(Arrays.asList(keystroke));
	}
	
	public static class PressingResult {
		public List<String> keystrokes;
		public long max;
		public PressingResult(List<String> keystrokes, long max) {
			this.keystrokes = keystrokes;
			this.max = max;
		}
	}
	
	private PressingResult max(PressingResult r1, PressingResult r2) {
		return r1.max >= r2.max ? r1 : r2;
	}
}
