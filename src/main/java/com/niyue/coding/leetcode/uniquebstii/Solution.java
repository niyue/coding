package com.niyue.coding.leetcode.uniquebstii;

import java.util.ArrayList;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_95
// generate all unique binary search trees recursively
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        ArrayList<TreeNode> allTrees = new ArrayList<TreeNode>();
        if(n == 0) {
            allTrees.add(null);
        } else {
            allTrees = genTrees(1, n);
        }
        return allTrees;
    }

    private ArrayList<TreeNode> genTrees(int start, int end) {
        ArrayList<TreeNode> allTrees = new ArrayList<TreeNode>();
        if(start <= end) {
            if(start == end) {
                TreeNode root = new TreeNode(start);
                allTrees.add(root);
            } else {
                allTrees.addAll(leftNullRightTrees(start, end));  
                allTrees.addAll(leftRightTrees(start, end));
                allTrees.addAll(leftRightNullTrees(start, end));
            }
        }   
        return allTrees;        
    }

    private ArrayList<TreeNode> leftNullRightTrees(int start, int end) {
        ArrayList<TreeNode> allTrees = new ArrayList<TreeNode>(); 
        ArrayList<TreeNode> rightTrees = genTrees(start + 1, end); 
        for(TreeNode rightTree : rightTrees) {
            TreeNode root = new TreeNode(start);
            root.right = rightTree;
            allTrees.add(root);
        }  
        return allTrees;
    }

    private ArrayList<TreeNode> leftRightTrees(int start, int end) {
        ArrayList<TreeNode> allTrees = new ArrayList<TreeNode>(); 
        for(int i = start + 1; i < end; i++) {
            ArrayList<TreeNode> leftTrees = genTrees(start, i - 1);
            ArrayList<TreeNode> rightTrees = genTrees(i + 1, end);
            for(TreeNode leftTree : leftTrees) {
                for(TreeNode rightTree : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    allTrees.add(root);   
                }
            }
        }
        return allTrees;
    }

    private ArrayList<TreeNode> leftRightNullTrees(int start, int end) {
        ArrayList<TreeNode> allTrees = new ArrayList<TreeNode>(); 
        ArrayList<TreeNode> leftTrees = genTrees(start, end - 1); 
        for(TreeNode leftTree : leftTrees) {
            TreeNode root = new TreeNode(end);
            root.left = leftTree;
            allTrees.add(root);
        }  
        return allTrees;
    }
}
