package com.niyue.coding.leetcode.minimumdepthofbinarytree;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_111
public class Solution {
    public int minDepth(TreeNode root) {
        int minDepth = 0;
        if(root != null) {
            int leftMin = minDepth(root.left);
            int rightMin = minDepth(root.right);
            if(root.left == null && root.right != null) {
                minDepth = 1 + rightMin;
            } else if(root.left != null && root.right == null) {
                minDepth = 1 + leftMin;
            } else {
                minDepth = 1 + Math.min(leftMin, rightMin);
            }
        }
        return minDepth;
    }
}
