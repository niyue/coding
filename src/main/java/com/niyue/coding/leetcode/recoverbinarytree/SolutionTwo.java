package com.niyue.coding.leetcode.recoverbinarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 *  http://oj.leetcode.com/problems/recover-binary-search-tree/
 *  Implement an iterative inorder to find the nodes that needs to be recovered
 */
public class SolutionTwo {
    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>(4);
        TreeNode prev = null;
        TreeNode current = root;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while(!stack.isEmpty() || current != null) {
            if(current != null) {
                stack.offerFirst(current);
                current = current.left;
            } else {
                TreeNode node = stack.pollFirst();
                if(prev != null && node.val < prev.val) {
                    nodes.add(prev);
                    nodes.add(node);
                }
                prev = node;
                current = node.right;
            }
        }
        if(nodes.size() == 2) {
            swap(nodes, 0, 1);
        } else {
            swap(nodes, 0, 3);
        }
    }
    
    private void swap(List<TreeNode> nodes, int i, int j) {
        int temp = nodes.get(i).val;
        nodes.get(i).val = nodes.get(j).val;
        nodes.get(j).val = temp;     
    }
}
