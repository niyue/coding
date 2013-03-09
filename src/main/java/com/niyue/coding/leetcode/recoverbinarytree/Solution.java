package com.niyue.coding.leetcode.recoverbinarytree;

import java.util.ArrayList;
import java.util.List;

import com.niyue.coding.leetcode.common.TreeNode;

public class Solution {
    private TreeNode peak;
    private TreeNode bottom;
    private List<TreeNode> queue;

    public void recoverTree(TreeNode root) {
    	peak = null;
    	bottom = null;
        if(root != null) {
            queue = new ArrayList<TreeNode>(3);
            visit(root);
            peakOrBottomForLast(queue);
            swap(peak, bottom);
        }
    }   

    private void visit(TreeNode node) {
        if(node != null) {
            visit(node.left);
            enqueue(node);
            peakOrBottom(queue);
            visit(node.right);    
        }
    }

    private void enqueue(TreeNode node) {
        queue.add(node);
        if(queue.size() > 3) {
            queue.remove(0);
        }
    }

    private void peakOrBottom(List<TreeNode> nodes) {
        if(nodes.size() == 2) {
            if(nodes.get(0).val > nodes.get(1).val) {
                peak = nodes.get(0);
            }
        } else if(nodes.size() == 3) {
            if(nodes.get(1).val > nodes.get(0).val && nodes.get(1).val > nodes.get(2).val) {
            	if(peak == null) {
            		peak = nodes.get(1);
            	} else {
            		peak = peak.val > nodes.get(1).val ? peak : nodes.get(1);
            	}
            } else if(nodes.get(1).val < nodes.get(0).val && nodes.get(1).val < nodes.get(2).val) {
            	if(bottom == null) {
            		bottom = nodes.get(1);
            	} else {
            		bottom = bottom.val < nodes.get(1).val ? bottom : nodes.get(1);
            	}
            }
        }
    }

    private void peakOrBottomForLast(List<TreeNode> nodes) {
        if(nodes.size() == 2) {
            if(nodes.get(1).val < nodes.get(0).val) {
                bottom = nodes.get(1);
            }
        } else if(nodes.size() == 3) {
            if(nodes.get(2).val < nodes.get(1).val) {
            	if(bottom == null) {
            		bottom = nodes.get(2);
            	} else {
            		bottom = bottom.val < nodes.get(2).val ? bottom : nodes.get(2);
            	}
            }
        }
    }

    private void swap(TreeNode one, TreeNode two) {
        int temp = one.val;
        one.val = two.val;
        two.val = temp;
    }
}
