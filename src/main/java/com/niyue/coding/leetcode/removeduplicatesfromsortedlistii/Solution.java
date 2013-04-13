package com.niyue.coding.leetcode.removeduplicatesfromsortedlistii;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_82
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head != null) {
            ListNode current = head;
            head = null;
            ListNode prev = null;
            while(current != null) {
                if(isDuplicated(current)) {
                    current = removeDuplicate(current, prev);
                } else {
                    if(head == null) {
                        head = current;
                    }
                    
                    if(current != null) {
                        prev = current;
                        current = current.next;
                    }
                }
            }
        }
        return head;
    }

    private boolean isDuplicated(ListNode node) {
        return node.next == null ? false : node.val == node.next.val;
    }

    private ListNode removeDuplicate(ListNode current, ListNode prev) {
        int val = current.val;
        while(current != null && current.val == val) {
            if(prev != null) {
                prev.next = current.next;
            }
            current = current.next;
        }
        return current;        
    }
}
