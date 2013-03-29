package com.niyue.coding.leetcode.mergeksortedlists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.niyue.coding.leetcode.common.ListNode;

// http://leetcode.com/onlinejudge#question_23
// Merge k sorted linked lists and return it as one sorted list.
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>(16, new ListNodeComparator());
        for(ListNode node : lists) {
        	if(node != null) {
        		queue.offer(node);
        	}
        }        
        ListNode head = null;
        ListNode current = null;
        while(!queue.isEmpty()) {
            ListNode min = queue.poll();
            if(head == null) {
                head = min;
                current = head;
            } else {
                current.next = min;
                current = current.next;
            }
            if(min.next != null) {
            	queue.offer(min.next);
            }
        }
        if(current != null) {
            current.next = null;
        }
        return head;
    }
    
    private static class ListNodeComparator implements Comparator<ListNode> {
		@Override
		public int compare(ListNode n1, ListNode n2) {
			return n1.val - n2.val;
		}
    }
}
