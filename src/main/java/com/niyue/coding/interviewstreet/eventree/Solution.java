package com.niyue.coding.interviewstreet.eventree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    
    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
    	Set<Edge> edges = getInput();
    	Map<Integer, List<Integer>> treeConnections = treeConnections(edges);
    	Set<Edge> removableEdges = removableEdges(edges, treeConnections);
        System.out.println(removableEdges.size());
    }
    
    /**
     * BFS traversal of the sub tree to get one of the sub tree after removing an edge
     */
    private Set<Integer> connectedVertices(Map<Integer, List<Integer>> tree, Edge removedEdge) {
    	Set<Integer> visitedVertices = new HashSet<Integer>();
    	visitedVertices.add(removedEdge.getV1());
    	
    	List<Integer> vertices = new LinkedList<Integer>();
    	vertices.add(removedEdge.getV2());
    	while(!vertices.isEmpty()) {
    		int vertex = vertices.get(0);
    		vertices.remove(0);
    		if(!visitedVertices.contains(vertex)) {
    			visitedVertices.add(vertex);
    			vertices.addAll(tree.get(vertex));
    		}
    	}
    	visitedVertices.remove(Integer.valueOf(removedEdge.getV1()));
    	return visitedVertices;
    }
    
    private Set<Edge> getInput() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt(); // N is always equal to M+1 and not used at all
        int M = scanner.nextInt();
        Set<Edge> edges = new HashSet<Edge>();
        for(int i=0;i<M;i++) {
        	int v1 = scanner.nextInt();
        	int v2 = scanner.nextInt();
        	edges.add(new Edge(v1, v2));
        }
        scanner.close();
        return edges;
    }
    
    private Map<Integer, List<Integer>> treeConnections(Set<Edge> tree) {
    	Map<Integer, List<Integer>> treeConnections = new HashMap<Integer, List<Integer>>();
    	for(Edge edge : tree) {
    		addEdge(treeConnections, edge.getV1(), edge.getV2());
    		addEdge(treeConnections, edge.getV2(), edge.getV1());
    	}
    	return treeConnections;
    }
    
    private void addEdge(Map<Integer, List<Integer>> tree, int v1, int v2) {
    	if(!tree.containsKey(v1)) {
    		tree.put(v1, new ArrayList<Integer>());
    	}
    	tree.get(v1).add(v2);
    }
    
    private Set<Edge> removableEdges(Set<Edge> tree, Map<Integer, List<Integer>> treeConnections) {
    	Set<Edge> removableEdges = new HashSet<Edge>();
    	for(Edge edge : tree) {
    		if(isRemovable(treeConnections, edge)) {
    			removableEdges.add(edge);
    		}
    	}
    	
    	return removableEdges;
    }
    
    private boolean isRemovable(Map<Integer, List<Integer>> treeConnections, Edge edge) {
    	Set<Integer> connectedVertices = connectedVertices(treeConnections, edge);
    	return isEven(connectedVertices.size());
    }
    
    private boolean isEven(int count) {
    	return count % 2 == 0;
    }
    
    private static class Edge {
    	private int v1;
    	private int v2;
    	public Edge(int v1, int v2) {
    		this.v1 = v1;
    		this.v2 = v2;
    	}
    	public int getV1() {
    		return v1;
    	}
    	public int getV2() {
    		return v2;
    	}
    }
}
