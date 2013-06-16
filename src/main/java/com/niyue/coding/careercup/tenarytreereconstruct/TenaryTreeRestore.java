package com.niyue.coding.careercup.tenarytreereconstruct;

//http://www.careercup.com/question?id=7756669
// A much simpler and more efficient O(n) solution to reconstruct a tenary tree from its preorder
public class TenaryTreeRestore {
	private int cursor = 0;
	public TreeNode reconstruct(String preorder) {
		cursor = 0;
		return reconstruct(preorder.toCharArray());
	}
	
	private TreeNode reconstruct(char[] preorder) {
		char currentNode = preorder[cursor];
		boolean isInternalNode = currentNode == 'I';
		TreeNode root = new TreeNode(!isInternalNode);
		cursor++;
		if(isInternalNode) {
			root.children[0] = reconstruct(preorder);
			root.children[1] = reconstruct(preorder);
			root.children[2] = reconstruct(preorder);
		}
		
		return root;
	}
}
