package com.niyue.coding.careercup.mergebst;

import com.niyue.coding.leetcode.common.TreeNode;

// http://www.careercup.com/question?id=8255895
// Merge two BST in place (O(lgn) stack space is used during constructing BST from a sorted list)
public class MergeBst {
	public TreeNode merge(TreeNode t1, TreeNode t2) {
		TreeNode l1 = toList(t1);
		TreeNode l2 = toList(t2);
		TreeNode list = mergeList(l1, l2);
		TreeNode tree = toTree(list);
		return tree;
	}
	
	private TreeNode toList(TreeNode t) {
		TreeNode head = null;
		if(t != null) {
			if(t.left != null) {
				TreeNode leftList = toList(t.left);
				leftList.right = t;
				t.left = leftList;
				head = leftList;
			} else {
				head = t;
			}
			if(t.right != null) {
				TreeNode rightList = toList(t.right);
				t.right = rightList;
				rightList.left = t;
			}
		}
		return head;
	}
	
	private TreeNode mergeList(TreeNode l1, TreeNode l2) {
		TreeNode c1 = l1;
		TreeNode c2 = l2;
		TreeNode head = c1 != null && c2 != null 
						? c1.val <= c2.val ? c1 : c2 
						: c1 != null ? c1 : c2;
		TreeNode prev = null;
		while(c1 != null && c2 != null) {
			TreeNode current = c1.val <= c2.val ? c1 : c2;
			if(prev != null) {
				prev.right = current;
			}
			current.left = prev;
			prev = current;
			if(c1.val <= c2.val) {
				c1 = c1.right;
			} else {
				c2 = c2.right;
			}
		}
		TreeNode remain = c1 != null ? c1 : c2;
		if(remain != null && prev != null) {
			prev.right = remain;
			remain.left = prev;
		}
		return head;
	}
	
	private TreeNode toTree(TreeNode list) {
		int length = getLength(list);
		TreeNode root = toTree(list, 0, length - 1)[0];
		return root;
	}
	
	private int getLength(TreeNode list) {
		int len = 0;
		while(list != null) {
			len++;
			list = list.right;
		}
		return len;
	}
	
	private TreeNode[] toTree(TreeNode cursor, int start, int end) {
		TreeNode parent = null;
		if(start <= end) {
			int mid = start + (end - start) / 2;
			TreeNode[] leftTree = toTree(cursor, start, mid - 1);
			cursor = leftTree[1];
			parent = cursor;
			cursor = cursor.right;
			TreeNode[] rightTree = toTree(cursor, mid + 1, end);
			parent.left = leftTree[0];
			parent.right = rightTree[0];
			cursor = rightTree[1];
		}
		return new TreeNode[] {parent, cursor};
	}
}
