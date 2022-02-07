package com.ashx.gfg.graph;

import java.util.List;

public class DetectCycleInUndirectedGraph {
    public static void main(String[] args) {
        System.out.println(detectCycle(GraphUtil.getDisconnectedUndirectedGraph()));
    }

    public static boolean detectCycle(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, int s, boolean[] visited, int parent) {
        visited[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                if (dfs(adj, u, visited, s)) {
                    return true;
                } else if (u != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
