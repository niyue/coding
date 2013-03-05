package com.niyue.coding.leetcode.sametree;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_100
// recursively check if left and right sub tree are the same
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean same = false;
        if(p == null && q == null) {
            same = true;
        } else if(p != null && q != null) {
            same = 
                p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
        }
        return same;
    }
}
