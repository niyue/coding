package com.niyue.coding.leetcode.sumroottoleafnumbers;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 * http://oj.leetcode.com/problems/sum-root-to-leaf-numbers/
 * 20 lines less of code compared to the original solution
 */
public class SolutionTwo {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        sum(root, 0);
        return sum;
    }
    
    private void sum(TreeNode node, int path) {
        if(node != null) {
            path = path * 10 + node.val;
            if(node.left == null && node.right == null) {
                sum += path;
            } else {
                sum(node.left, path);    
                sum(node.right, path);
            }
        }
    }
}
