package com.niyue.coding.careercup.bsttwosum;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

import com.niyue.coding.leetcode.common.TreeNode;

class InorderIterator implements Iterator<TreeNode> {
    private Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    private TreeNode current = null;
    
    public InorderIterator(TreeNode root) {
    	current = root;
    }
    
	@Override
	public boolean hasNext() {
		return !stack.isEmpty() || current != null;
	}

	@Override
	public TreeNode next() {
		if(hasNext()) {
			return nextNode();
		} else {
			throw new NoSuchElementException();
		}
	}
	
	private TreeNode nextNode() {
		while(current != null) {
			stack.addFirst(current);
			current = current.left;
		}
		current = stack.removeFirst();
		TreeNode next = current;
		current = current.right;
		return next;
	}

	@Override
	public void remove() {
		 throw new UnsupportedOperationException("remove() is not implemented");
	}
}