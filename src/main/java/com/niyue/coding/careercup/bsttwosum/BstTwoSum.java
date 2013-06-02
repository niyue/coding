package com.niyue.coding.careercup.bsttwosum;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.niyue.coding.leetcode.common.TreeNode;

// Find two sum in BST in O(n)
// http://www.careercup.com/question?id=15320677
// Implement an InorderIterator for BST and an ReverseInorderIterator for BST,
// so that a BST can be iterated sequentially like a list,
// and the two sum problem in BST can be converted into the two sum problem for a sorted linked list,
// which can be solved in O(n) by searching from both ends
public class BstTwoSum {
    public List<List<Integer>> twoSum(TreeNode root, int target) {
        Iterator<TreeNode> head = new InorderIterator(root);
        Iterator<TreeNode> tail = new ReverseInorderIterator(root);
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(head.hasNext() && tail.hasNext()) {
            int headValue = head.next().val;
            int tailValue = tail.next().val;
            while(headValue < tailValue) {
                if(headValue + tailValue == target) {
                    result.add(Arrays.asList(headValue, tailValue));
                    if(head.hasNext() && tail.hasNext()) {
                        headValue = head.next().val;
                        tailValue = tail.next().val;
                    } else {
                        break;
                    }
                } else if(headValue + tailValue < target && head.hasNext()) {
                    headValue = head.next().val;
                } else if(headValue + tailValue > target && tail.hasNext()) {
                    tailValue = tail.next().val;
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
