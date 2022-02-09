package com.ashx.gfg.graph;

public class BridgesInGraph {
    public static void main(String[] args) {
        BGraph g = new BGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        printBridges(g);
    }

    public static void printBridges(BGraph graph) {
        int V = graph.V;
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];

        for (int i = 0; i < V; i++) {
            parent[i] = BGraph.NIL;
            visited[i] = false;
        }

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                bridgeUtil(i, visited, disc, low, parent, graph);
            }
        }
    }

    private static void bridgeUtil(int u, boolean[] visited, int[] disc, int[] low, int[] parent, BGraph graph) {
        visited[u] = true;
        disc[u] = low[u] = ++graph.time;

        for (Edge edge : graph.adj[u]) {
            int v = edge.dest;
            if (!visited[v]) {
                parent[v] = u;
                bridgeUtil(v, visited, disc, low, parent, graph);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    System.out.println(u + " " + v);
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static class BGraph extends Graph {
        static final int NIL = -1;

        int time = 0;

        BGraph(int v) {
            super(v);
        }
    }
}
