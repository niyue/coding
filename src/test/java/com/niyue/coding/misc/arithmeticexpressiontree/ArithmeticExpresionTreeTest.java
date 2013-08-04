package com.niyue.coding.misc.arithmeticexpressiontree;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticExpresionTreeTest {

	@Test
	public void testOnlyOneNumber() {
		ETreeNode root = new ETreeNode(1);
		assertThat(root.toString(), is("1"));
	}
	
	@Test
	public void testSimplePlusExpression() {
		ETreeNode root = new ETreeNode("+");
		root.left = new ETreeNode(1);
		root.right = new ETreeNode(2);
		assertThat(root.toString(), is("1 + 2"));
	}
	
	@Test
	public void testSimpleMultiplyExpression() {
		ETreeNode root = new ETreeNode("*");
		root.left = new ETreeNode(1);
		root.right = new ETreeNode(2);
		assertThat(root.toString(), is("1 * 2"));
	}

	@Test
	public void testMultiplyAndPlusExpression() {
		ETreeNode root = new ETreeNode("+");
		root.left = new ETreeNode("*");
		root.left.left = new ETreeNode(2);
		root.left.right = new ETreeNode(3);
		root.right = new ETreeNode(1);
		assertThat(root.toString(), is("2 * 3 + 1"));
	}
	
	@Test
	public void testPlusAndMultiplyExpression() {
		ETreeNode root = new ETreeNode("*");
		root.left = new ETreeNode("+");
		root.left.left = new ETreeNode(2);
		root.left.right = new ETreeNode(3);
		root.right = new ETreeNode(1);
		assertThat(root.toString(), is("(2 + 3) * 1"));
	}
	
	@Test
	public void testPlusAndDivideAndPlusExpression() {
		ETreeNode root = new ETreeNode("/");
		root.left = new ETreeNode("+");
		root.left.left = new ETreeNode(2);
		root.left.right = new ETreeNode(3);
		root.right = new ETreeNode("-");
		root.right.left = new ETreeNode(4);
		root.right.right = new ETreeNode(5);
		assertThat(root.toString(), is("(2 + 3) / (4 - 5)"));
	}
}
