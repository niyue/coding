package com.niyue.coding.careercup.syncreader;

// http://www.careercup.com/question?id=15082668
/*
 * given: unsigned char read_byte(); ← side effect that it advances a byte pointer in the stream 
 * write: unsigned char read_sync_byte(); ← may result in >1 calls to read_byte() 
 * remove byte '03' from the stream if the stream is in pattern 00 00 03 
 * Example: 
 * read_byte(): 
 * 00 0f 42 17 00 00 03 74 00 00 00 00 14 ... 
 * read_sync_byte(): 
 * 00 0f 42 17 00 00 74 00 00 00 00 14 ...
 */
public class SyncReader {
	private final CharStream stream;
	private State status = State.NO_ZERO;
	private Character nextNext;

	public SyncReader(String chars) {
		this.stream = new CharStream(chars);
	}
	
	public char read() {
		char next;
		if(nextNext != null) {
			next = nextNext;
			nextNext = null;
		} else {
			next = stream.read();
		}
		if(next == '0') {
			switch(status) {
			case NO_ZERO:
				status = State.ONE_ZERO;
				break;
			case ONE_ZERO:
				status = State.TWO_ZERO;
				break;
			case TWO_ZERO:
				status = State.THREE_ZERO;
				break;
			case THREE_ZERO:
				status = State.FOUR_ZERO;
				break;
			case FOUR_ZERO:
				nextNext = stream.read();
				if(nextNext == '0') {
					status = State.FOUR_ZERO;
				} else if(nextNext == '3') {
					nextNext = null;
					next = stream.read();
					status = next == '0' ? State.ONE_ZERO : State.NO_ZERO;
				} else {
					status = State.NO_ZERO;
				}
				break;
			case FIVE_ZERO:
				break;
			default:
				break;
			}
		}
		return next;
	}
	
	private static enum State {
		NO_ZERO,
		ONE_ZERO,
		TWO_ZERO,
		THREE_ZERO,
		FOUR_ZERO,
		FIVE_ZERO;
	}
}
