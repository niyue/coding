package com.niyue.coding.careercup.tenarytreereconstruct;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;
import org.junit.Test;

public class TenaryTreeReconstructTest {
	@Test
	public void testSingleNode() {
		TenaryTreeReconstruct ttr = new TenaryTreeReconstruct();
		TreeNode root = ttr.reconstruct("L");
		assertThat(root.preorder(), is("L"));
	}
	
	@Test
	public void testFourNodes() {
		TenaryTreeReconstruct ttr = new TenaryTreeReconstruct();
		TreeNode root = ttr.reconstruct("ILLL");
		assertThat(root.preorder(), is("ILLL"));
	}
	
	@Test
	public void testSevenNodes() {
		TenaryTreeReconstruct ttr = new TenaryTreeReconstruct();
		TreeNode root = ttr.reconstruct("ILILLLL");
		assertThat(root.preorder(), is("ILILLLL"));
	}
	
	@Test
	public void testComplexTree() {
		TenaryTreeReconstruct ttr = new TenaryTreeReconstruct();
		TreeNode root = ttr.reconstruct("ILILILLLLILILLLL");
		assertThat(root.preorder(), is("ILILILLLLILILLLL"));
	}
	
	@Test
	public void testMiddleNodesTree() {
		TenaryTreeReconstruct ttr = new TenaryTreeReconstruct();
		TreeNode root = ttr.reconstruct("ILILILLLLL");
		assertThat(root.preorder(), is("ILILILLLLL"));
	}
	
	@Test
	// the last fourth node should be an *incomplete* internal node (instead of only internal node)
	public void testLongMiddleNodesTree() {
		TenaryTreeReconstruct ttr = new TenaryTreeReconstruct();
		TreeNode root = ttr.reconstruct("ILILILILLLLLL");
		assertThat(root.preorder(), is("ILILILILLLLLL"));
	}
}
