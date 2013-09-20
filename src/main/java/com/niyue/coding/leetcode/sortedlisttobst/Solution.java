package com.niyue.coding.leetcode.sortedlisttobst;

import com.niyue.coding.leetcode.common.ListNode;
import com.niyue.coding.leetcode.common.TreeNode;

// http://oj.leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
// http://leetcode.com/onlinejudge#question_109
// O(n) solution to convert sorted linked list to BST
public class Solution {
    private ListNode cursor = null;
    public TreeNode sortedListToBST(ListNode head) {
        int length = getLength(head);
        cursor = head;
        return listToBST(0, length - 1);
    }
    
    private TreeNode listToBST(int start, int end) {
        TreeNode parent = null;
        if(start <= end) {
            int mid = start + (end - start) / 2;
            TreeNode left = listToBST(start, mid - 1);
            parent = new TreeNode(cursor.val);
            cursor = cursor.next; // NOTE: use a member variable so that this cursor advancement will take effect 
            TreeNode right = listToBST(mid + 1, end);
            parent.left = left;
            parent.right = right;    
        }
        return parent;
    }
    
    private int getLength(ListNode head) {
        int length = 0;
        ListNode current = head;
        while(current != null) {
            current = current.next;
            length++;
        }
        return length;
    }
}
