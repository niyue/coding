package com.niyue.coding.leetcode.pathsumii;

import java.util.ArrayList;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 * http://oj.leetcode.com/problems/path-sum-ii/
 */
public class SolutionTwo {
    private ArrayList<ArrayList<Integer>> solutions;
    private int target;
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        solutions = new ArrayList<ArrayList<Integer>>();
        target = sum;
        visit(root, 0, new ArrayList<Integer>());
        return solutions;
    }
    
    private void visit(TreeNode node, int sum, ArrayList<Integer> path) {
        if(node != null) {
            path.add(node.val);
            sum += node.val;
            if(isLeaf(node)) {
                if(sum == target) {
                    solutions.add(new ArrayList<Integer>(path));    
                }
            } else {
                visit(node.left, sum, path);
                visit(node.right, sum, path);
            }
            sum -= node.val;
            path.remove(path.size() - 1);
        }
    }
    
    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
