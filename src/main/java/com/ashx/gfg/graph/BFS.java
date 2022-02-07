package com.ashx.gfg.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
    public static void main(String[] args) {
        bfs(GraphUtil.getConnectedUndirectedGraph(), 0); // O(V + E)
        System.out.println();

        int connectedComponents = bfsDisconnected(GraphUtil.getDisconnectedUndirectedGraph()); // O(V + E)
        System.out.println();
        System.out.println("Connected components count: " + connectedComponents);
    }

    public static void bfs(List<List<Integer>> adj, int s) {
        boolean[] visited = new boolean[adj.size()];
        bfs(adj, s, visited);
    }

    public static int bfsDisconnected(List<List<Integer>> adj) {
        int V = adj.size();
        int count = 0;
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bfs(adj, i, visited);
                count++;
            }
        }
        return count;
    }

    private static void bfs(List<List<Integer>> adj, int s, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
        while (!q.isEmpty()) {
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
