package com.niyue.coding.misc.blockread;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32026405.html
 */
public class StreamReader {
	private final BlockReader blockReader;
	private char[] buffer;
	private int bufferCursor = 0;
	private int bufferLength;
	
	public StreamReader(BlockReader blockReader) {
		this.blockReader = blockReader;
	}
	
	public int read(char[] dest, int size) {
		int length = readRemainingBuffer(dest, size);
		
		while(length < size) {
			buffer = new char[BlockReader.BLOCK_SIZE];
			bufferCursor = 0;
			bufferLength = blockReader.blockRead(buffer);
			if(bufferLength == 0) {
				break;
			}
			while(length < size && bufferCursor < bufferLength) {
				dest[length] = buffer[bufferCursor];
				length++;
				bufferCursor++;
			}
		}
		return length;
	}
	
	private int readRemainingBuffer(char[] dest, int size) {
		int length = 0;
		if(buffer != null) {
			while(length < size && bufferCursor < bufferLength) {
				dest[length] = buffer[bufferCursor];
				length++;
				bufferCursor++;
			}
			if(bufferCursor == bufferLength) {
				buffer = null;
			}
		}
		return length;
	}
}
