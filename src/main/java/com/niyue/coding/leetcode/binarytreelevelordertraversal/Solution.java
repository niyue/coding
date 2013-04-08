package com.niyue.coding.leetcode.binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_102
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
		if(root != null) {
			Queue<TreeNode> queue = new LinkedList<TreeNode>();
			queue.offer(null);
			queue.offer(root);
			while(queue.size() > 1 || queue.peek() != null) {
				TreeNode node = queue.poll();
				if(node == null) {
					levels.add(allValues(queue));
					queue.offer(null);
				} else {
					if(node.left != null) {
						queue.offer(node.left);
					}
					if(node.right != null) {
						queue.offer(node.right);
					}	
				}
			}
		}
		return levels;
    }

    private ArrayList<Integer> allValues(Queue<TreeNode> queue) {
    	ArrayList<Integer> values = new ArrayList<Integer>();
    	for(TreeNode node : queue) {
    		values.add(node.val);
    	}
    	return values;
    }
}
