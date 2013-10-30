package com.niyue.coding.leetcode.clonegraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * http://oj.leetcode.com/problems/clone-graph/
 */
public class Solution {
    private Map<UndirectedGraphNode, UndirectedGraphNode> visited;
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        visited = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return clone(node);
    }
    
    private UndirectedGraphNode clone(UndirectedGraphNode node) {
        UndirectedGraphNode clone = null;
        if(node != null) {
            if(!visited.containsKey(node)) {
                clone = new UndirectedGraphNode(node.label);
                // NOTE: cloned node should be put into map immediately instead of after cloning all its neighbors
                visited.put(node, clone);
                for(UndirectedGraphNode neighbor : node.neighbors) {
                    UndirectedGraphNode clonedNeighbor = clone(neighbor);
                    clone.neighbors.add(clonedNeighbor);
                }
            } else {
                clone = visited.get(node);
            }    
        }
        return clone;
    }
    
    class UndirectedGraphNode {
    	int label;
    	ArrayList<UndirectedGraphNode> neighbors;
    	UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
}