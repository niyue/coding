package com.niyue.coding.leetcode.treeinorder;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_94
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode current = root;
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.addFirst(current);
                current = current.left;
            } else {
                current = stack.removeFirst();
                values.add(current.val);
                current = current.right;
            }
        }       
        return values;
    }
}
