package com.niyue.coding.interviewstreet.farvertices;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    private int numberOfVertices; // N
    private int maxDistance; // K

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() throws NumberFormatException, IOException {
        List<Connection> edges = getInput();
        
        int[][] distances = distances(edges);
        
        NavigableMap<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap = distanceVertexConnectionsMap(distances);
        
        Entry<Integer, Map<Integer, Set<Connection>>> mostDistantEntry = distanceVertexConnectionsMap.lastEntry();
        int markCount = 0;
        while(mostDistantEntry.getKey() > maxDistance) {
        	int furthestDistance = mostDistantEntry.getKey();
        	int vertexToMark = selectVertexToMark(distanceVertexConnectionsMap, furthestDistance);
        	markVertex(distanceVertexConnectionsMap, vertexToMark);
        	markCount++;
        	mostDistantEntry = distanceVertexConnectionsMap.lastEntry();
        }
        System.out.println(markCount);
    }
    
    private NavigableMap<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap(int[][] distances) {
    	NavigableMap<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap = new TreeMap<Integer, Map<Integer, Set<Connection>>>();
    	for(int i=1;i<=numberOfVertices;i++) {
    		for(int j=i+1;j<=numberOfVertices;j++) {
    			int distance = distances[i][j];
    			if(!distanceVertexConnectionsMap.containsKey(distance)) {
    				distanceVertexConnectionsMap.put(distance, new HashMap<Integer, Set<Connection>>());
    			}
    			Map<Integer, Set<Connection>> vertexConnectionsMap = distanceVertexConnectionsMap.get(distance);
    			if(!vertexConnectionsMap.containsKey(i)) {
    				vertexConnectionsMap.put(i, new HashSet<Connection>());
    			}
    			if(!vertexConnectionsMap.containsKey(j)) {
    				vertexConnectionsMap.put(j, new HashSet<Connection>());
    			}
    			Connection i2j = new Connection(i, j);
    			vertexConnectionsMap.get(i).add(i2j);
    			vertexConnectionsMap.get(j).add(i2j);
    		}
    	}
    	return distanceVertexConnectionsMap;
    }
    
    private void markVertex(NavigableMap<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap, int vertex) {
    	Iterator<Entry<Integer, Map<Integer, Set<Connection>>>> iterator = distanceVertexConnectionsMap.entrySet().iterator();
    	while(iterator.hasNext()) {
    		Entry<Integer, Map<Integer, Set<Connection>>> entry = iterator.next();
    		int distance = entry.getKey();
    		if(distanceVertexConnectionsMap.containsKey(distance)) {
    			Map<Integer, Set<Connection>> vertexConnectionsMap = distanceVertexConnectionsMap.get(distance);
    			if(vertexConnectionsMap.containsKey(vertex)) {
    				List<Connection> markedVertexConnections = new ArrayList<Connection>(vertexConnectionsMap.get(vertex));
    				for(Connection connection : markedVertexConnections) {
    					vertexConnectionsMap.get(connection.getV1()).remove(connection);
    					vertexConnectionsMap.get(connection.getV2()).remove(connection);
    				}
    				
    				Iterator<Entry<Integer, Set<Connection>>> iter = vertexConnectionsMap.entrySet().iterator();
    				while(iter.hasNext()) {
    					Set<Connection> connections = iter.next().getValue();
    					if(connections.isEmpty()) {
    						iter.remove();
    					}
    				}
    				
    				if(vertexConnectionsMap.isEmpty()) {
    					iterator.remove();
    				}
    			}
    		}
    	}
    }
    
    private int selectVertexToMark(NavigableMap<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap, int distance) {
    	Map<Integer, Set<Connection>> vertexConnectionsMap = distanceVertexConnectionsMap.get(distance);
    	int maxVertex = 0;
    	for(Entry<Integer, Set<Connection>> vertexCount : vertexConnectionsMap.entrySet()) {
    		if(isBigger(vertexCount.getKey(), maxVertex, distance, distanceVertexConnectionsMap)) {
    			maxVertex = vertexCount.getKey();
    		}
    	}
    	return maxVertex;
    }
    
    private boolean isBigger(int currentVertex, int maxVertex, int distance, NavigableMap<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap) {
    	boolean isBigger = false;
    	if(distance > 0) {
	    	if(distanceVertexConnectionsMap.containsKey(distance)) {
	    		Map<Integer, Set<Connection>> vertexConnectionsMap = distanceVertexConnectionsMap.get(distance);
	    		int currentVertexCount = vertexConnectionsMap.containsKey(currentVertex) ? vertexConnectionsMap.get(currentVertex).size() : 0;
	    		int maxVertexCount = vertexConnectionsMap.containsKey(maxVertex) ? vertexConnectionsMap.get(maxVertex).size() : 0;
	    		if(currentVertexCount > maxVertexCount) {
	    			isBigger = true;
	    		} else if(currentVertexCount == maxVertexCount) {
	    			isBigger = isBigger(currentVertex, maxVertex, distance-1, distanceVertexConnectionsMap);
	    		}
	    	} else {
	    		isBigger = isBigger(currentVertex, maxVertex, distance-1, distanceVertexConnectionsMap);
	    	}
    	} else {
    		isBigger = true;
    	}
    	return isBigger;
    }
    
    private List<Connection> getInput() {
        Scanner scanner = new Scanner(System.in);
        numberOfVertices = scanner.nextInt();
        maxDistance = scanner.nextInt();
        
        List<Connection> edges = new ArrayList<Connection>(numberOfVertices-1);
        for(int i=0;i<numberOfVertices-1;i++) {
            int edgeVertextOne = scanner.nextInt();
            int edgeVertextTwo = scanner.nextInt();
            edges.add(new Connection(edgeVertextOne, edgeVertextTwo));
        }
        scanner.close();
        return edges;
    }
       
    private int[][] distances(List<Connection> edges) {
        // one based index array
        int[][] distances = new int[numberOfVertices + 1][numberOfVertices + 1];
        Map<Integer, Set<Integer>> connections = new HashMap<Integer, Set<Integer>>();
        for(Connection edge : edges) {
            int v1 = edge.getV1();
            int v2 = edge.getV2();
            distances[v1][v2] = 1;
            distances[v2][v1] = 1;
            addConnection(connections, v1, v2);
            addConnection(connections, v2, v1);
        }

        Set<Integer> visitedVertices = new HashSet<Integer>();
        traverse(connections, distances, visitedVertices, edges.get(0).getV1(), -1);
        return distances;
    }
    
    private void traverse(Map<Integer, Set<Integer>> connections, int[][] distances, Set<Integer> visitedVertices, int vertex, int fromVertex) {
    	if(!visitedVertices.contains(vertex)) {
    		for(int visitedVertex : visitedVertices) {
    			expandVertex(distances, vertex, fromVertex, visitedVertex);
    		}
    		visitedVertices.add(vertex);
    		Set<Integer> connectedVertices = connections.get(vertex);
    		for(int connectedVertex : connectedVertices) {
    			traverse(connections, distances, visitedVertices, connectedVertex, vertex);
    		}
    	}
    }
    
    private void expandVertex(int[][] distances, int expandedVertex, int fromVertex, int visitedVertex) {
		distances[visitedVertex][expandedVertex] = distances[fromVertex][visitedVertex] + 1;
		distances[expandedVertex][visitedVertex] = distances[visitedVertex][expandedVertex];
    }

    private void addConnection(Map<Integer, Set<Integer>> connections, int v1, int v2) {
        if(!connections.containsKey(v1)) {
            connections.put(v1, new HashSet<Integer>());
        }
        connections.get(v1).add(v2);
    }

    private static class Connection {
        private int v1, v2;
        public Connection(int v1, int v2) {
            this.v1 = Math.min(v1, v2);
            this.v2 = Math.max(v1, v2);
        }

        public int getV1() {
            return v1;
        }

        public int getV2() {
            return v2;
        }

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + v1;
			result = prime * result + v2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Connection other = (Connection) obj;
			if (v1 != other.v1)
				return false;
			if (v2 != other.v2)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return String.format("[%d,%d]", v1, v2);
		}
    }
}