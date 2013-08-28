package com.niyue.coding.misc.blockread;

/*
 * http://www.mitbbs.com/article_t/JobHunting/32026405.html
 */
public class BlockReader {
	public final static int BLOCK_SIZE = 4;
	private final char[] source;
	private int cursor = 0;
	public BlockReader(char[] source) {
		this.source = source;
	}
	
	public int blockRead(char[] buffer) {
		int length = 0;
		while (cursor < source.length && length < BLOCK_SIZE) {
			buffer[length++] = source[cursor++];
		}
		return length;
	}
}
