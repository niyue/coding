package com.niyue.coding.leetcode.bottomupleveltraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_102
// BFS to traverse the tree and reverse the entire result at the end
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
        	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        	queue.offer(root);
        	queue.offer(null);
        	levels.add(new ArrayList<Integer>());
        	while(!(queue.size() == 1 && queue.peek() == null)) {
        		TreeNode node = queue.poll();
        		if(node == null) {
        			levels.add(new ArrayList<Integer>());
        			queue.offer(null);
        		} else {
        			levels.get(levels.size() - 1).add(node.val);
        			if(node.left != null) {
        				queue.offer(node.left);
        			}
        			if(node.right != null) {
        				queue.offer(node.right);
        			}
        		}
        	}
        	Collections.reverse(levels);
        }
        return levels;
    }
}
