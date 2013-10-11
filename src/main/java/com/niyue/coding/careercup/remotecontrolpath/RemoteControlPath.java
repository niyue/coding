package com.niyue.coding.careercup.remotecontrolpath;

/*
 * http://www.careercup.com/question?id=6741345771192320
 */
public class RemoteControlPath {
	public String getKeys(int width, String word) {
		assert width > 0;
		char start = 'a';
		StringBuilder keys = new StringBuilder();
		for(char c : word.toCharArray()) {
			String path = getPath(start, c, width); 
			keys.append(path).append("!");
			start = c;
		}
		return keys.toString();
	}
	
	private String getPath(char start, char c, int width) {
		StringBuilder path = new StringBuilder();
		int ys = (start - 'a') / width;
		int xs = (start - 'a') % width;
		int yc = (c - 'a') / width;
		int xc = (c - 'a') % width;
		char verticalChar = yc > ys ? 'd' : 'u';
		char horizontalChar = xc > xs ? 'r' : 'l';
		for(int i = 0; i < Math.abs(yc - ys); i++) {
			path.append(verticalChar);
		}
		for(int i = 0; i < Math.abs(xc - xs); i++) {
			path.append(horizontalChar);
		}
		return path.toString();
	}
}
