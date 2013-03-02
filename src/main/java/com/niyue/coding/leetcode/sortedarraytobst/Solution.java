package com.niyue.coding.leetcode.sortedarraytobst;

import com.niyue.coding.leetcode.common.TreeNode;

public class Solution {
    public TreeNode sortedArrayToBST(int[] num) {
        return toBST(num, 0, num.length - 1);           
    }
    
    private TreeNode toBST(int[] num, int start, int end) {
        TreeNode bst = null;
        if(start <= end) {
            int middle = (start + end) / 2;
            TreeNode node = new TreeNode(num[middle]);
            TreeNode leftTree = toBST(num, start, middle - 1);
            TreeNode rightTree = toBST(num, middle + 1, end);    
            node.left = leftTree;
            node.right = rightTree;
            bst = node;
        }
        return bst;
    }
}
