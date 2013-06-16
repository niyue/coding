package com.niyue.coding.careercup.tenarytreereconstruct;


public class TreeNode {
	public final boolean isLeaf;
	public boolean isComplete = false;
	public TreeNode[] children = new TreeNode[3];
	
	public TreeNode() {
		this(true);
	}
	
	public TreeNode(boolean isLeaf) {
		this.isLeaf = isLeaf;
		this.isComplete = isLeaf;
	}
	
	public String preorder() {
		StringBuilder preorder = new StringBuilder(isLeaf ? "L" : "I");
		if(!isLeaf) {
			preorder.append(children[0].preorder());
			preorder.append(children[1].preorder());
			preorder.append(children[2].preorder());
		}
		return preorder.toString();
	}
}
