package com.niyue.coding.leetcode.sortedarraytobst;

import com.niyue.coding.leetcode.common.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return convert(num, 0, num.length - 1);
    }
    
    private TreeNode convert(int[] num, int start, int end) {
        TreeNode node = null;
        if(start <= end) {
            int mid = start + (end - start) / 2;
            node = new TreeNode(num[mid]);
            node.left = convert(num, start, mid - 1);
            node.right = convert(num, mid + 1, end);
        }
        return node;
    }
}
