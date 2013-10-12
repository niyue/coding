package com.niyue.coding.leetcode.sametree;

import com.niyue.coding.leetcode.common.TreeNode;

/*
 * http://oj.leetcode.com/problems/same-tree/
 * http://leetcode.com/onlinejudge#question_100
 * recursively check if left and right sub tree are the same
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean isSame = p == null && q == null;
        if(!isSame && p != null && q != null) {
            isSame = p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return isSame;
    }
}
