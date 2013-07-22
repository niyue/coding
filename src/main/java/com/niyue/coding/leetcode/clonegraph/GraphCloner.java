package com.niyue.coding.leetcode.clonegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// http://leetcode.com/2012/05/clone-graph-part-i.html
// Clone a connected undirected graph
public class GraphCloner {
	private Map<GraphNode, GraphNode> nodeMap = new HashMap<GraphNode, GraphNode>();
	public GraphNode clone(GraphNode node) {
		GraphNode copy = copyOf(node);
		nodeMap.put(node, copy);
		for(GraphNode neighbour : node.neighbours) {
			if(!nodeMap.containsKey(neighbour)) {
				copy.neighbours.add(clone(neighbour));
			} else {
				copy.neighbours.add(nodeMap.get(neighbour));
			}
		}
		return copy;
	}
	
	private GraphNode copyOf(GraphNode node) {
		return new GraphNode(node.value);
	}
	
	public static class GraphNode {
		public final int value;
		public List<GraphNode> neighbours = new ArrayList<GraphNode>();
		public GraphNode(int value) {
			this.value = value;
		}
	}
}
