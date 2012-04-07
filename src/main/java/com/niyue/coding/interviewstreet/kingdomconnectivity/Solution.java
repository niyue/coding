package com.niyue.coding.interviewstreet.kingdomconnectivity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private static final long INFINITE = -1;
    private Map<Integer, List<Integer>> routes;
    private Set<Integer> currentRoute = new HashSet<Integer>();
    private Set<Integer> loopNodes = new HashSet<Integer>();
    private Set<Integer> reachableNodes = new HashSet<Integer>();
    private int N, M;

    public static void main(String[] args) throws java.lang.Exception {
        Solution sl = new Solution();
        sl.solve();
    }

    public void solve() {
        routes = getInputRoutes();
        long routeCount = routeCount(1, N, currentRoute);
        for (Integer node : loopNodes) {
            if (reachableNodes.contains(node)) {
                routeCount = INFINITE;
                break;
            }
        }
        printRouteCount(routeCount);
    }

    private void printRouteCount(long routeCount) {
        String routeCountValue = routeCount == INFINITE ? "INFINITE PATHS"
                : String.valueOf(routeCount % 1000000000);
        System.out.println(routeCountValue);
    }

    private long routeCount(int start, int end, Set<Integer> currentRoute) {
        currentRoute.add(start);

        List<Integer> connections = routes.get(start);
        long routeCount = 0;
        if (connections != null) {
            for (Integer connectedNode : connections) {
                if (currentRoute.contains(connectedNode)) {
                    loopNodes.add(connectedNode);
                } else if (connectedNode == end) {
                    routeCount++;
                    reachableNodes.add(connectedNode);
                    reachableNodes.addAll(currentRoute);
                } else {
                    long connectedNodeCount = routeCount(connectedNode, end,
                            currentRoute);
                    routeCount += connectedNodeCount;
                }
            }
        }
        currentRoute.remove(start);
        return routeCount;
    }

    private Map<Integer, List<Integer>> getInputRoutes() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        Map<Integer, List<Integer>> connections = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < M; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            if (!connections.containsKey(source)) {
                connections.put(source, new LinkedList<Integer>());
            }
            connections.get(source).add(dest);
        }

        return connections;
    }
}
