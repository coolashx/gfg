package com.ashx.gfg.graph;

import java.util.List;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        System.out.println(detect(GraphUtil.getDisconnectedDirectedGraph()));
    }

    public static boolean detect(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        boolean[] recurStack = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (dfs(adj, i, visited, recurStack)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, int s, boolean[] visited, boolean[] recurStack) {
        visited[s] = true;
        recurStack[s] = true;
        for (int u : adj.get(s)) {
            if (!visited[u] && dfs(adj, u, visited, recurStack)) {
                return true;
            } else if (recurStack[u]) {
                return true;
            }
        }
        recurStack[s] = false;
        return false;
    }
}
