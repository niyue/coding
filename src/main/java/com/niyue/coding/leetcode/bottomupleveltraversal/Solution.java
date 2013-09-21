package com.niyue.coding.leetcode.bottomupleveltraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.niyue.coding.leetcode.common.TreeNode;

// http://oj.leetcode.com/problems/binary-tree-level-order-traversal-ii/
// http://leetcode.com/onlinejudge#question_107
// BFS to traverse the tree and reverse the entire result at the end
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
        	// NOTE: ArrayDeque cannot be used in this case because queue.offer(null) will throw NPE for ArrayDeque
        	Queue<TreeNode> queue = new LinkedList<TreeNode>();
        	queue.offer(null);
        	queue.offer(root);
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
