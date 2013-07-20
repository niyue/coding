package com.niyue.coding.misc.kclosestnodesinbst;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.niyue.coding.leetcode.common.TreeNode;

// http://www.mitbbs.com/article_t1/JobHunting/32268547_0_2.html
// http://csjobinterview.wordpress.com/2012/06/29/find-k-nodes-in-bst-that-are-closest-to-a-value-key-part-ii/
// There is a BST while each node has distinct values, 
// then for a given value key, find out K nodes in this BST such that their values are closest to key.
// O(lgN + K) solution:
// 1) find the closest node 
// 2) find the previous K-1 nodes for inorder traversal for the closest node 
// 3) find the next K-1 nodes for inorder traversal for the closest node
// 4) output the K nodes from (closest node, K-1 previous nodes, K-1 next nodes) using merge
public class KClosestNodesInBst {
	public List<TreeNode> search(TreeNode root, int target, int k) {
		assert k > 0;
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		stack.offerFirst(root);
		TreeNode closestNode = null;
		Map<TreeNode, TreeNode> parents = new HashMap<TreeNode, TreeNode>();
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pollFirst();
			if(node.left != null) {
				parents.put(node.left, node);
			}
			if(node.right != null) {
				parents.put(node.right, node);
			}
			if(node != null) {
				if(closestNode == null || 
						Math.abs(node.val - target) < Math.abs(closestNode.val - target)) {
					closestNode = node;
					if(closestNode.val == target) {
						break;
					}
				}
				TreeNode branchToSearch = target < node.val ? node.left : node.right;
				if(branchToSearch != null) {
					stack.offerLast(branchToSearch);
				}
			}
		}
		
		List<TreeNode> closestNodes = findKClosestNodes(closestNode, parents, target, k);
		return closestNodes;
	}
	
	private List<TreeNode> findKClosestNodes(TreeNode closestNode, Map<TreeNode, TreeNode> parents, int target, int k) {
		List<TreeNode> prevKNodes = prevKNodes(closestNode, parents, k - 1);
		List<TreeNode> nextKNodes = nextKNodes(closestNode, parents, k - 1);
		List<TreeNode> closestNodes = new ArrayList<TreeNode>();
		closestNodes.add(closestNode);
		for(int i = 0, j = 0; i < prevKNodes.size() && j < nextKNodes.size() && closestNodes.size() < k;) {
			TreeNode nextClosestNode = null;
			if(Math.abs(prevKNodes.get(i).val - target) <= Math.abs(nextKNodes.get(j).val - target)) {
				nextClosestNode = prevKNodes.get(i);
				i++;
			} else {
				nextClosestNode = nextKNodes.get(j);
				j++;
			}
			closestNodes.add(nextClosestNode);
		}
		return closestNodes;
	}
	
	// find the previous in order k nodes for any given node 
	private List<TreeNode> prevKNodes(TreeNode node, Map<TreeNode, TreeNode> parents, int k) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode stackNode = node;
		stack.offerLast(stackNode);
		while(stackNode != null) {
			TreeNode parent = parents.get(stackNode);
			if(parent != null && parent.right == stackNode) {
				stack.offerLast(parent);
			}
			stackNode = parent;
		}
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		TreeNode current = node;
	    while((!stack.isEmpty() || current != null) && nodes.size() < k){
	        if(current != null && current != node){
	            stack.offerFirst(current);
	            current = current.right;
	        } else {
	            current = stack.pollFirst();
	            if(current != node) {
	            	nodes.add(current);
	            }
	            current = current.left;
	        }
	    }
		return nodes;
	}
	
	// find the next in order k nodes for any given node
	private List<TreeNode> nextKNodes(TreeNode node, Map<TreeNode, TreeNode> parents, int k) {
		Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
		TreeNode stackNode = node;
		stack.offerLast(stackNode);
		while(stackNode != null) {
			TreeNode parent = parents.get(stackNode);
			if(parent != null && parent.left == node) {
				stack.offerLast(parent);
			}
			stackNode = parent;
		}
		List<TreeNode> nodes = new ArrayList<TreeNode>();
		
		TreeNode current = node;
	    while((!stack.isEmpty() || current != null) && nodes.size() < k){
	        if(current != null && current != node){
	            stack.offerFirst(current);
	            current = current.left;
	        } else {
	            current = stack.pollFirst();
	            if(current != node) {
	            	nodes.add(current);
	            }
	            current = current.right;
	        }
	    }
		return nodes;
	}
}
