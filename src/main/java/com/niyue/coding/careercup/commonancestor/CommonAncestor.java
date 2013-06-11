package com.niyue.coding.careercup.commonancestor;

// find common ancestor of two tree nodes
public class CommonAncestor {
	public TreeNode findCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
		Result result = countAndFind(root, n1, n2);
		return result.commonAncestor;
	}
	
	private Result countAndFind(TreeNode root, TreeNode n1, TreeNode n2) {
		int count = 0;
		TreeNode commonAncestor = null;
		if(root != null) {
			if(root.equals(n1) || root.equals(n2)) {
				count++;
			} 
			Result leftResult = countAndFind(root.left, n1, n2);
			Result rightResult = countAndFind(root.right, n1, n2);
			if(leftResult.commonAncestor != null) {
				commonAncestor = leftResult.commonAncestor;
			} else if(rightResult.commonAncestor != null){
				commonAncestor = rightResult.commonAncestor;
			} else {
				count += leftResult.count + rightResult.count;
				if(count == 2) {
					commonAncestor = root;
				}
			}
		}
		return new Result(count, commonAncestor);
	}
	
	private static class Result {
		public final int count;
		public final TreeNode commonAncestor;
		public Result(int count, TreeNode ancestor) {
			this.count = count;
			this.commonAncestor = ancestor;
		}
	}
}
