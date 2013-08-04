package com.niyue.coding.misc.arithmeticexpressiontree;

import java.util.Arrays;
import java.util.List;

/*
 *  Given an arithmetic expression tree, whose internal nodes have values with arithmetic operations, including: +,-,*,/
 *  Return its string representation.
 *  For example, a tree like:
 *        *
 *     +      *
 *   1   2  4   5
 *  We should return (1 + 2) * 4 * 5
 *  Unnecessary parenthesis is not allowed, for example, (1 + 2) * (4 * 5) is not allowed.
 *  Implemented using a recursive solution, but this will result a n(lgn) solution since formatting string will copy both left and right sub strings.
 *  An iterative solution using StringBuilder could improve the algorithm to be an O(n) solution.
 */
public class ETreeNode {
	private static final List<String> ops = Arrays.asList("+", "-", "*", "/");
	private static final List<String> lowerOps = Arrays.asList("+", "-");
	private static final List<String> higherOps = Arrays.asList("*", "/");
	
	public final String value;
	public ETreeNode left;
	public ETreeNode right;
	public ETreeNode(String value) {
		this.value = value;
	}
	
	public ETreeNode(Integer value) {
		this.value = value.toString();
	}
	
	@Override
	public String toString() {
		String string = value;
		if(isOpNode()) {
			String leftNode = childNode(left);
			String rightNode = childNode(right);
			string = String.format("%s %s %s", leftNode, value, rightNode);
		}
		return string;
	}
	
	private String childNode(ETreeNode child) {
		String childNode = child.toString();
		if(child.isOpNode() && lowerPriority(child.value, value)) {
			childNode = String.format("(%s)", childNode);
		}
		return childNode;
	}
			
	private boolean isOpNode() {
		return ops.contains(value);
	}
	
	private boolean lowerPriority(String op1, String op2) {
		return lowerOps.contains(op1) && higherOps.contains(op2);
	}
}
