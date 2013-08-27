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
	
	public int read(char[] buf, int size) {
		int length = 0;
		if(buffer != null) {
			while(length < size && bufferCursor < bufferLength) {
				buf[length] = buffer[bufferCursor];
				length++;
				bufferCursor++;
			}
			if(bufferCursor == bufferLength) {
				buffer = null;
			}
		}
		while(length < size) {
			buffer = new char[BlockReader.BLOCK_SIZE];
			bufferCursor = 0;
			int blockLength = blockReader.blockRead(buffer);
			if(blockLength == 0) {
				break;
			}
			while(length < size && bufferCursor < blockLength) {
				buf[length] = buffer[bufferCursor];
				length++;
				bufferCursor++;
			}
		}
		return length;
	}
}
