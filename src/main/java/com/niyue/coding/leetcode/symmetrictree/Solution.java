package com.niyue.coding.leetcode.symmetrictree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.niyue.coding.leetcode.common.TreeNode;

// http://leetcode.com/onlinejudge#question_101
// non recursive solution to this problem, use BFS to traverse the tree level by level and check the symmetricity level by level
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        boolean isSymmetric = true;
        if(root != null) {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            queue.offer(null);
            List<TreeNode> level = new ArrayList<TreeNode>();
            level.add(root.left);
            level.add(root.right);
            
            while(!(queue.size() == 1 && queue.peek() == null)) {
                TreeNode node = queue.poll();
                if(node == null) {
                	isSymmetric = isSymmetric(level);
                	if(!isSymmetric) {
                		break;
                	}
                	level = new ArrayList<TreeNode>();
                    queue.offer(null);
                } else {
                    if(node.left != null) {
                        queue.offer(node.left);
                    } 
                    
                    if(node.right != null) {
                        queue.offer(node.right);
                    }
                    
                    level.add(node.left);
                    level.add(node.right);
                }
            }
        }
        return isSymmetric;
    }

    private boolean isSymmetric(List<TreeNode> level) {
        boolean isSymmetric = true;
        for(int i = 0; i <= level.size() / 2; i++) {
            TreeNode front = level.get(i);
            TreeNode back = level.get(level.size() - 1 - i);
            if(front == null && back == null) {
            	continue;
            } else if((front == null && back != null) || 
               (front != null && back == null) || 
                front.val != back.val) {
                isSymmetric = false;
                break;
            }
        }
        return isSymmetric;
    }
    
    /**
     * A recursive solution to this problem
     */
    public static class RecursiveSolution {
    	public boolean isSymmetric(TreeNode root) {
    		boolean isSymmetric = true;
    		if(root != null) {
    			isSymmetric = isSymmetric(root.left, root.right);
    		}
    		return isSymmetric;
    	}
    	
    	private boolean isSymmetric(TreeNode left, TreeNode right) {
    		boolean isSymmetric = false;
    		if(left == null && right == null) {
    			isSymmetric = true;
    		} else if(left != null && right != null) {
    			isSymmetric = 
    					left.val == right.val && 
    					isSymmetric(left.left, right.right) && 
    					isSymmetric(left.right, right.left);
    		}
    		return isSymmetric;
    	}
    }
}

