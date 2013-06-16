package com.niyue.coding.careercup.tenarytreereconstruct;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TenaryTreeRestoreTest {
	@Test
	public void testSingleNode() {
		TenaryTreeRestore ttr = new TenaryTreeRestore();
		TreeNode root = ttr.reconstruct("L");
		assertThat(root.preorder(), is("L"));
	}
	
	@Test
	public void testFourNodes() {
		TenaryTreeRestore ttr = new TenaryTreeRestore();
		TreeNode root = ttr.reconstruct("ILLL");
		assertThat(root.preorder(), is("ILLL"));
	}
	
	@Test
	public void testSevenNodes() {
		TenaryTreeRestore ttr = new TenaryTreeRestore();
		TreeNode root = ttr.reconstruct("ILILLLL");
		assertThat(root.preorder(), is("ILILLLL"));
	}
	
	@Test
	public void testComplexTree() {
		TenaryTreeRestore ttr = new TenaryTreeRestore();
		TreeNode root = ttr.reconstruct("ILILILLLLILILLLL");
		assertThat(root.preorder(), is("ILILILLLLILILLLL"));
	}
	
	@Test
	public void testMiddleNodesTree() {
		TenaryTreeRestore ttr = new TenaryTreeRestore();
		TreeNode root = ttr.reconstruct("ILILILLLLL");
		assertThat(root.preorder(), is("ILILILLLLL"));
	}
	
	@Test
	// the last fourth node should be an *incomplete* internal node (instead of only internal node)
	public void testLongMiddleNodesTree() {
		TenaryTreeRestore ttr = new TenaryTreeRestore();
		TreeNode root = ttr.reconstruct("ILILILILLLLLL");
		assertThat(root.preorder(), is("ILILILILLLLLL"));
	}
}
