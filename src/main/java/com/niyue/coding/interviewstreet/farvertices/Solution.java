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
    private int[][] distances;
    private Map<Integer, Map<Integer, Integer>> distanceVertexMap;
    private Map<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() throws NumberFormatException, IOException {
        List<Connection> edges = getInput();
        distances = distances(edges);
        NavigableMap<Integer, Set<Connection>> distanceMap = distanceMap(distances);
        distanceVertexMap = distanceVertexMap(distanceMap);
        distanceVertexConnectionsMap = distanceVertexConnectionsMap(distances);
        
        Entry<Integer, Set<Connection>> mostDistantEntry = distanceMap.lastEntry();
        int markCount = 0;
        while(mostDistantEntry.getKey() > maxDistance) {
        	int markVertex = selectVertexToMark(mostDistantEntry.getKey());
        	
        	markCount++;
        	markVertex(markVertex, distanceMap);
        	mostDistantEntry = distanceMap.lastEntry();
        }
        System.out.println(markCount);
    }
    
    private Map<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap(int[][] distances) {
    	Map<Integer, Map<Integer, Set<Connection>>> distanceVertexConnectionsMap = new HashMap<Integer, Map<Integer, Set<Connection>>>();
    	for(int i=1;i<=numberOfVertices;i++) {
    		for(int j=i+1;j<=numberOfVertices;j++) {
    			int distance = distances[i][j];
    			if(!distanceVertexConnectionsMap.containsKey(distance)) {
    				Map<Integer, Set<Connection>> vertexConnectionsMap = new HashMap<Integer, Set<Connection>>();
    				distanceVertexConnectionsMap.put(distance, vertexConnectionsMap);
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
    
    private void markVertex(int vertex, NavigableMap<Integer, Set<Connection>> distanceMap) {
    	Iterator<Entry<Integer, Set<Connection>>> iterator = distanceMap.entrySet().iterator();
    	while(iterator.hasNext()) {
    		Entry<Integer, Set<Connection>> entry = iterator.next();
    		int distance = entry.getKey();
    		Set<Connection> connections = entry.getValue();
    		
    		Set<Connection> vertexConnections = distanceVertexConnectionsMap.get(distance).get(vertex);
    		for(Connection vertexConnection : vertexConnections) {
    			connections.remove(vertexConnection);
    			int v1 = vertexConnection.getV1();
	    		int v2 = vertexConnection.getV2();
    			Map<Integer, Integer> vertexCount = distanceVertexMap.get(distance);
    			decreaseCount(vertexCount, v1);
    			decreaseCount(vertexCount, v2);
    		}
    		if(connections.isEmpty()) {
    			iterator.remove();
    		}
    		distanceVertexConnectionsMap.get(distance).remove(vertex);
    	}
    }
    
    private int selectVertexToMark(int distance) {
    	Map<Integer, Integer> vertexCountMap = distanceVertexMap.get(distance);
    	int vertex = 0;
    	int max = -1;
    	for(Entry<Integer, Integer> vertexCount : vertexCountMap.entrySet()) {
    		if(vertexCount.getValue() > max) {
    			vertex = vertexCount.getKey();
    			max = vertexCount.getValue();
    		}
    	}
    	return vertex;
    }
    
    private Map<Integer, Map<Integer, Integer>> distanceVertexMap(NavigableMap<Integer, Set<Connection>> distanceMap) {
    	Map<Integer, Map<Integer, Integer>> distanceVertexMap = new HashMap<Integer, Map<Integer, Integer>>();
    	for(Entry<Integer, Set<Connection>> distanceConnections : distanceMap.entrySet()) {
    		int distance = distanceConnections.getKey();
    		Set<Connection> connections = distanceConnections.getValue();
    		Map<Integer, Integer> vertexCount = new HashMap<Integer, Integer>();
    		for(Connection conn : connections) {
    			int v1 = conn.getV1();
    			int v2 = conn.getV2();
    			increaseCount(vertexCount, v1);
    			increaseCount(vertexCount, v2);
    		}
    		distanceVertexMap.put(distance, vertexCount);
    	}
    	return distanceVertexMap;
    }
    
    private void increaseCount(Map<Integer, Integer> vertexCount, int v) {
    	if(!vertexCount.containsKey(v)) {
    		vertexCount.put(v, 1);
    	} else {
    		vertexCount.put(v, vertexCount.get(v) + 1);
    	}
    }
    
    private void decreaseCount(Map<Integer, Integer> vertexCount, int v) {
    	if(vertexCount.containsKey(v)) {
    		int count = vertexCount.get(v);
    		if(count == 1) {
    			vertexCount.remove(v);
    		} else {
    			vertexCount.put(v, count-1);
    		}
    	}
    }
    
    private List<Connection> getInput() throws NumberFormatException, IOException {
        Scanner scanner = new Scanner(System.in);
        numberOfVertices = scanner.nextInt();
        maxDistance = scanner.nextInt();
        
        List<Connection> edges = new ArrayList<Connection>(numberOfVertices-1);
        for(int i=0;i<numberOfVertices-1;i++) {
            int edgeVertextOne = scanner.nextInt();
            int edgeVertextTwo = scanner.nextInt();
            edges.add(new Connection(edgeVertextOne, edgeVertextTwo));
        }

        return edges;
    }
    
    private NavigableMap<Integer, Set<Connection>> distanceMap(int[][] distances) {
    	NavigableMap<Integer, Set<Connection>> distanceMap = new TreeMap<Integer, Set<Connection>>();
    	for(int i=1;i<=numberOfVertices;i++) {
    		for(int j=i+1;j<=numberOfVertices;j++) {
    			int distance = distances[i][j];
    			if(!distanceMap.containsKey(distance)) {
    				Set<Connection> connections = new HashSet<Connection>();
    				distanceMap.put(distance, connections);
    			}
    			distanceMap.get(distance).add(new Connection(i, j));
    		}
    	}
    	return distanceMap;
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

        Set<Integer> visistedVertices = new HashSet<Integer>();
        for(Connection edge : edges) {
            int v1 = edge.getV1();
            int v2 = edge.getV2();
            if(visistedVertices.isEmpty()) {
                visistedVertices.add(v1);
                visistedVertices.add(v2);
            } else {
                int expandedVertex = visistedVertices.contains(v1) ? v2 : v1;
                int visitedVertex = visistedVertices.contains(v1) ? v1 : v2;
                Set<Integer> connectedVertices = connections.get(visitedVertex);
                for(int connectedVertex : connectedVertices) {
                	if(expandedVertex != connectedVertex) {
                		distances[connectedVertex][expandedVertex] = distances[connectedVertex][visitedVertex] + 1;
                		distances[expandedVertex][connectedVertex] = distances[connectedVertex][expandedVertex];
                		addConnection(connections, connectedVertex, expandedVertex);
                		addConnection(connections, expandedVertex, connectedVertex);
                	}
                }
                visistedVertices.add(expandedVertex);
            }
        }
        return distances;
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