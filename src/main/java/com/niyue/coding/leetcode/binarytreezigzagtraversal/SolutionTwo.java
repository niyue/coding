package com.niyue.coding.leetcode.binarytreezigzagtraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 * http://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class SolutionTwo {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> order = new ArrayList<ArrayList<Integer>>();
        if(root != null) {
            boolean reversed = false;
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            queue.offer(null);
            ArrayList<Integer> level = new ArrayList<Integer>();
            while(queue.size() > 1 || queue.peek() != null) {
                TreeNode top = queue.poll();
                if(top == null) {
                    if(reversed) {
                        Collections.reverse(level);
                    }
                    order.add(level);
                    queue.offer(null);
                    reversed = !reversed;
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
            if(reversed) {
                Collections.reverse(level);
            }
            order.add(level);    
        }
        
        return order;
    }
}
