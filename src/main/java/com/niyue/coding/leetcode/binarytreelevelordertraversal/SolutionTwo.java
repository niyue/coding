package com.niyue.coding.leetcode.binarytreelevelordertraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 * http://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class SolutionTwo {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> levels = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            queue.offer(null);
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(queue.size() > 1 || queue.peek() != null) {
                TreeNode top = queue.poll();
                if(top == null) {
                    levels.add(level);
                    queue.offer(null);
                    level = new ArrayList<Integer>();
                } else {
                    level.add(top.val);
                    if(top.left != null) {
                        queue.offer(top.left);    
                    } 
                    if(top.right != null) {
                        queue.offer(top.right);    
                    }
                }
            }    
            levels.add(level);
        }
        return levels;
    }
}
