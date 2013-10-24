package com.niyue.coding.leetcode.maxdepthofbinarytree;

import com.niyue.coding.leetcode.common.TreeNode;

// http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
// http://leetcode.com/onlinejudge#question_104
public class Solution {
    public int maxDepth(TreeNode root) {
        int depth = 0;
        if(root != null) {
            depth = 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
        return depth;
    }
}
