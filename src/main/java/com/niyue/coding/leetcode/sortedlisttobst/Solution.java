package com.niyue.coding.leetcode.sortedlisttobst;

import com.niyue.coding.leetcode.common.ListNode;
import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_109
// O(n) solution to convert sorted linked list to BST
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);
        
        return (TreeNode) convert(head, 0, length - 1)[0];
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        for(ListNode cursor = head; cursor != null; cursor = cursor.next) {
            length++;
        }
        return length;
    }
    
    private Object[] convert(ListNode node, int start, int end) {
        TreeNode root = null;
        if(start <= end) {
            int mid = start + (end - start) / 2;
            Object[] treeNodeAndListNode = convert(node, start, mid - 1);
            TreeNode left = (TreeNode) treeNodeAndListNode[0];
            node = (ListNode) treeNodeAndListNode[1];
            TreeNode parent = new TreeNode(node.val);
            node = node.next;
            treeNodeAndListNode = convert(node, mid + 1, end);
            TreeNode right = (TreeNode) treeNodeAndListNode[0];
            node = (ListNode) treeNodeAndListNode[1];
            parent.left = left;
            parent.right = right;    
            root = parent;
        }
        
        return new Object[] {root, node};
    }
}
