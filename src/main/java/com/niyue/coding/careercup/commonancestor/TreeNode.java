package com.niyue.coding.careercup.commonancestor;

public class TreeNode {
	public final int id;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
