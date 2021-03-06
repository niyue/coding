package com.niyue.coding.leetcode.validatebst;

import java.util.Deque;
import java.util.LinkedList;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_98
// Iterative in order traversal for a tree
// a simpler in order tree traversal implementation can be found here, http://www.brilliantsheep.com/iterative-binary-tree-traversal-in-java/
public class IterativeSolution {
    public boolean isValidBST(TreeNode root) {
        boolean isBst = true;
        Integer prev = null;
        if(root != null) {
            Deque<TreeNode> stack = new LinkedList<TreeNode>();
            TreeNode current = root;
            stack.addFirst(current);
            while(!stack.isEmpty()) {
                while(current != null && current.left != null) {
                    stack.addFirst(current.left);
                    current = current.left;
                }
                current = stack.removeFirst();
                if(prev != null) {
                    if(current.val <= prev) {
                        isBst = false;
                        break;
                    }
                }
                prev = current.val;
                if(current.right != null) {
                    current = current.right;
                    stack.addFirst(current);
                } else {
                    current = null;
                }
            }
        }
        return isBst;
    }
}
