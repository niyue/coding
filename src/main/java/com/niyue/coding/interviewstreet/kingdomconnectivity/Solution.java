package com.niyue.coding.interviewstreet.kingdomconnectivity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private static final long INFINITE = -1;
    // source => target (number of routes to the same target)
    private Map<Integer, Map<Integer, Integer>> routes;
    private Set<Integer> currentRoute = new HashSet<Integer>();
    private Set<Integer> loopNodes = new HashSet<Integer>();
    private Set<Integer> reachableNodes = new HashSet<Integer>();
    private Map<Integer, Long> routeTable = new HashMap<Integer, Long>();
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
        if (routes.containsKey(N)) {
            for (Integer node : routes.get(N).keySet()) {
                long count = routeCount(node, N, new HashSet<Integer>());
                if (count > 0) {
                    routeCount = INFINITE;
                    break;
                }
            }
        }
        printRouteCount(routeCount);
    }

    private void printRouteCount(long routeCount) {
        String routeCountValue = routeCount == INFINITE ? "INFINITE PATHS"
                : String.valueOf(routeCount);
        System.out.println(routeCountValue);
    }

    private long routeCount(int start, int end, Set<Integer> currentRoute) {
        currentRoute.add(start);
        long routeCount = 0;
        if (routeTable.containsKey(start)) {
            routeCount = routeTable.get(start);
        } else {
            Map<Integer, Integer> connections = routes.get(start);
            if (connections != null) {
                for (Integer connectedNode : connections.keySet()) {
                    if (currentRoute.contains(connectedNode)) {
                        loopNodes.add(connectedNode);
                    } else if (connectedNode == end) {
                        routeCount += connections.get(connectedNode); // 1 * no
                                                                      // of
                                                                      // routes
                        reachableNodes.addAll(currentRoute);
                    } else {
                        long connectedNodeCount = routeCount(connectedNode,
                                end, currentRoute);
                        routeCount += connectedNodeCount
                                * connections.get(connectedNode);
                    }
                }
            }
            routeTable.put(start, routeCount);
        }
        currentRoute.remove(start);
        return routeCount % 1000000000;
    }

    private Map<Integer, Map<Integer, Integer>> getInputRoutes() {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        Map<Integer, Map<Integer, Integer>> connections = new HashMap<Integer, Map<Integer, Integer>>();
        for (int i = 0; i < M; i++) {
            int source = scanner.nextInt();
            int dest = scanner.nextInt();
            if (!connections.containsKey(source)) {
                connections.put(source, new HashMap<Integer, Integer>());
            }
            Map<Integer, Integer> sourceToTargetMap = connections.get(source);
            if (!sourceToTargetMap.containsKey(dest)) {
                sourceToTargetMap.put(dest, 1);
            } else {
                sourceToTargetMap.put(dest, sourceToTargetMap.get(dest) + 1);
            }
        }

        return connections;
    }
}
