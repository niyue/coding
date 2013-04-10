package com.niyue.coding.leetcode.pathsumii;

import java.util.ArrayList;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_113
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode node, int sum) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        if(node != null) {
            ArrayList<ArrayList<Integer>> subPaths = new ArrayList<ArrayList<Integer>>();
            if(node.left != null && node.right == null) {
                subPaths = pathSum(node.left, sum - node.val);              
            } else if(node.left == null && node.right != null) {
                subPaths = pathSum(node.right, sum - node.val);
            } else if(node.left != null && node.right != null) {
                subPaths = pathSum(node.left, sum - node.val);
                subPaths.addAll(pathSum(node.right, sum - node.val));
            } else {
                if(node.val == sum) {
                    ArrayList<Integer> path = new ArrayList<Integer>();
                    subPaths.add(path);
                }
            }

            for(ArrayList<Integer> subPath : subPaths) {
                subPath.add(0, node.val);
                paths.add(subPath);
            }
        }   
        return paths;             
    }
}
