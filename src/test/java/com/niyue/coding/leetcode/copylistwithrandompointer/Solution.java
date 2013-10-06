package com.niyue.coding.leetcode.copylistwithrandompointer;

/*
 * http://oj.leetcode.com/problems/copy-list-with-random-pointer/
 * Copy list with random pointer with O(1) space and O(n) time.
 * 1) Iterate the list, and creating a new list during iteration. Insert the new list node in between two old list nodes. 
 * 		So two lists will intersect with each other. The odd nodes in list is the original list nodes, and the even ones are the copied list nodes.
 * 2) Iterate the intersecting list (with 2N length), populate the random pointer of copied list nodes during iteration
 * 3) Restore the original list next pointer
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead = null;
        if(head != null) {
            RandomListNode current = head;
            while(current != null) {
                RandomListNode newNode = new RandomListNode(current.label);
                if(newHead == null) {
                    newHead = newNode;
                }
                RandomListNode next = current.next;
                current.next = newNode;
                newNode.next = next;
                current = next;
            }    
            current = head;
            while(current != null) {
                current.next.random = current.random == null ? null : current.random.next; 
                current = current.next.next;
            }
            current = head;
            while(current != null) {
                RandomListNode newNode = current.next;
                current.next = newNode.next;
                current = current.next;
                newNode.next = current == null ? null : current.next;
            }
        }
        return newHead;
    }
    
    private static class RandomListNode {
	      int label;
	      RandomListNode next, random;
	      RandomListNode(int x) { this.label = x; }
    };
}