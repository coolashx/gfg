package com.ashx.gfg.graph;

import java.util.List;

public class DFS {
    public static void main(String[] args) {
        dfs(GraphUtil.getConnectedUndirectedGraph(), 0);
        System.out.println();

        int connectedComponents = dfsDisconnected(GraphUtil.getDisconnectedUndirectedGraph()); // O(V + E)
        System.out.println();
        System.out.println("Connected components count: " + connectedComponents);
        System.out.println();
    }

    public static void dfs(List<List<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        dfs(adj, s, visited);
    }

    private static void dfs(List<List<Integer>> adj, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for (int u : adj.get(s)) {
            if (!visited[u]) {
                dfs(adj, u, visited);
            }
        }
    }

    public static int dfsDisconnected(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        int count = 0;
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }
}
