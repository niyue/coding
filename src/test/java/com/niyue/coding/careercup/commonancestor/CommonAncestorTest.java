package com.niyue.coding.careercup.commonancestor;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class CommonAncestorTest {

	@Test
	public void testTwoNodes() {
		CommonAncestor ca = new CommonAncestor();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		TreeNode commonAncestor = ca.findCommonAncestor(root, new TreeNode(1), new TreeNode(2));
		assertThat(commonAncestor, is(root));
	}
	
	@Test
	public void testTwoNodesReversed() {
		CommonAncestor ca = new CommonAncestor();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		TreeNode commonAncestor = ca.findCommonAncestor(root, new TreeNode(2), new TreeNode(1));
		assertThat(commonAncestor, is(root));
	}
	
	@Test
	public void testThreeNodes() {
		CommonAncestor ca = new CommonAncestor();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		TreeNode commonAncestor = ca.findCommonAncestor(root, new TreeNode(3), new TreeNode(2));
		assertThat(commonAncestor, is(root));
	}
	
	@Test
	public void testScrewedThreeNodes() {
		CommonAncestor ca = new CommonAncestor();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		TreeNode commonAncestor = ca.findCommonAncestor(root, new TreeNode(2), new TreeNode(3));
		assertThat(commonAncestor, is(new TreeNode(2)));
	}
	
	@Test
	public void testFourNodes() {
		CommonAncestor ca = new CommonAncestor();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		TreeNode commonAncestor = ca.findCommonAncestor(root, new TreeNode(4), new TreeNode(2));
		assertThat(commonAncestor, is(root));
		commonAncestor = ca.findCommonAncestor(root, new TreeNode(4), new TreeNode(3));
		assertThat(commonAncestor, is(new TreeNode(3)));
	}
	
	@Test
	public void testSixNodes() {
		CommonAncestor ca = new CommonAncestor();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(6);
		TreeNode commonAncestor = ca.findCommonAncestor(root, new TreeNode(4), new TreeNode(5));
		assertThat(commonAncestor, is(root));
		commonAncestor = ca.findCommonAncestor(root, new TreeNode(4), new TreeNode(2));
		assertThat(commonAncestor, is(root));
		
		commonAncestor = ca.findCommonAncestor(root, new TreeNode(4), new TreeNode(6));
		assertThat(commonAncestor, is(new TreeNode(3)));
	}
}
