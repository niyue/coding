package com.niyue.coding.careercup.bsttwosum;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.NoSuchElementException;

import com.niyue.coding.leetcode.common.TreeNode;

class InorderIterator implements Iterator<TreeNode> {
    private Deque<TreeNode> stack = new LinkedList<TreeNode>();
    private Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
    
    public InorderIterator(TreeNode root) {
        parents.put(root, null);
        TreeNode current = root;
        TreeNode parent = null;
		while(current != null) {
			stack.addFirst(current);
			parents.put(current, parent);
			parent = current;
			current = current.left;
		}
    }
    
	@Override
	public boolean hasNext() {
		return !stack.isEmpty();
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
		TreeNode next = null;
		if(!stack.isEmpty()) {
			TreeNode current = stack.removeFirst();
			TreeNode parent = parents.remove(current);
			
			if(current.right != null) {
				TreeNode nextNode = current.right;
				TreeNode nextParent = null;
				while(nextNode != null) {
					stack.addFirst(nextNode);
					nextParent = nextNode;
					nextNode = nextNode.left;
					parents.put(nextNode, nextParent);
				}
			} else {
				TreeNode childNode = current;
				TreeNode parentNode = parent;
				while(parentNode != null && childNode == parentNode.right) {
					childNode = parentNode;
					stack.removeFirst();
					parentNode = parents.remove(parentNode);
				}
			}
			next = current;
		}
		return next;
	}

	@Override
	public void remove() {
		 throw new UnsupportedOperationException("remove() is not implemented");
	}
}