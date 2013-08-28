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
	
	public int read(char[] dest, int totalSize) {
		int currentLength = readRemainingBuffer(dest, totalSize);
		
		while(currentLength < totalSize) {
			buffer = new char[BlockReader.BLOCK_SIZE];
			bufferCursor = 0;
			bufferLength = blockReader.blockRead(buffer);
			if(bufferLength == 0) {
				break;
			}
			currentLength = readBuffer(dest, currentLength, totalSize);
		}
		return currentLength;
	}
	
	private int readRemainingBuffer(char[] dest, int totalSize) {
		int length = readBuffer(dest, 0, totalSize);
		if(bufferCursor == bufferLength) {
			buffer = null;
		}
		return length;
	}
	
	private int readBuffer(char[] dest, int currentLength, int totalSize) {
		while(currentLength < totalSize && bufferCursor < bufferLength) {
			dest[currentLength++] = buffer[bufferCursor++];
		}
		return currentLength;
	}
}
