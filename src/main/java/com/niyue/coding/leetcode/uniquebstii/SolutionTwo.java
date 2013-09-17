package com.niyue.coding.leetcode.uniquebstii;

import java.util.ArrayList;

import com.niyue.coding.careercup.commonancestor.TreeNode;

/*
 * http://oj.leetcode.com/problems/unique-binary-search-trees-ii/
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 */
public class SolutionTwo {
    public ArrayList<TreeNode> generateTrees(int n) {
       return generateTrees(1, n);
    }
    
    private ArrayList<TreeNode> generateTrees(int min, int max) {
        ArrayList<TreeNode> trees = new ArrayList<TreeNode>();
        if(min > max) {
            trees.add(null);
        } else {
            for(int i = min; i <= max; i++) {
               ArrayList<TreeNode> leftTrees = generateTrees(min, i - 1);
               ArrayList<TreeNode> rightTrees = generateTrees(i + 1, max);
               for(TreeNode left : leftTrees) {
                   for(TreeNode right: rightTrees) {
                	   TreeNode root = new TreeNode(i);
                       root.left = left;
                       root.right = right;
                       trees.add(root);
                   }
               }
            }    
        }
        return trees;    
    }
}
