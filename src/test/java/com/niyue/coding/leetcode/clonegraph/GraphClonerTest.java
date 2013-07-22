package com.niyue.coding.leetcode.clonegraph;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.niyue.coding.leetcode.clonegraph.GraphCloner.GraphNode;

public class GraphClonerTest {

	@Test
	public void testOneNodeGraph() {
		GraphNode node = new GraphNode(1);
		GraphCloner cloner = new GraphCloner();
		GraphNode clone = cloner.clone(node);
		assertThat(clone.value, is(1));
		assertThat(clone.neighbours.isEmpty(), is(true));
	}
	
	@Test
	public void testTwoNodesGraph() {
		GraphNode node = new GraphNode(1);
		node.neighbours.add(new GraphNode(2));
		GraphCloner cloner = new GraphCloner();
		GraphNode clone = cloner.clone(node);
		assertThat(clone.value, is(1));
		assertThat(clone.neighbours.size(), is(1));
		assertThat(clone.neighbours.get(0).value, is(2));
		assertThat(clone.neighbours.get(0).neighbours.isEmpty(), is(true));
	}
	
	@Test
	public void testOneNodeGraphWithLoop() {
		GraphNode node = new GraphNode(1);
		node.neighbours.add(node);
		GraphCloner cloner = new GraphCloner();
		GraphNode clone = cloner.clone(node);
		assertThat(clone.value, is(1));
		assertThat(clone.neighbours.size(), is(1));
		assertThat(clone.neighbours.get(0).value, is(1));
	}
}
