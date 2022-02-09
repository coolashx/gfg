package com.ashx.gfg.graph;

import java.util.Arrays;

public class BellmanFordShortestPath {
    public static void main(String[] args) {
        Graph graph = new Graph(4, Graph.Type.Directed);
        // add edge 0-1 (or A-B)
        graph.addEdge(0, 1, 1);
        // add edge 0-2 (or A-C)
        graph.addEdge(0, 2, 4);
        // add edge 1-2 (or B-C)
        graph.addEdge(1, 2, -3);
        // add edge 1-3 (or B-D)
        graph.addEdge(1, 3, 2);
        // add edge 2-3 (or C-D)
        graph.addEdge(2, 3, 3);

        int src = 0;
        int[] dist = getMinDistance(graph, src);
        if (dist == null) {
            System.out.println("Graph contains negative weight cycle");
        } else {
            System.out.println("Minimum distance from " + src + " : " + Arrays.toString(dist));
        }
    }

    public static int[] getMinDistance(Graph graph, int src) {
        Edge[] edges = graph.getEdges();
        int V = graph.V;
        int[] dist = new int[V];

        for (int i = 0; i < V; ++i) {
            dist[i] = Integer.MAX_VALUE;
        }
        dist[src] = 0;

        for (int i = 1; i < V; ++i) {
            for (Edge edge : edges) {
                int u = edge.src;
                int v = edge.dest;
                int weight = edge.weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        for (Edge edge : edges) {
            int u = edge.src;
            int v = edge.dest;
            int weight = edge.weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                return null;
            }
        }
        return dist;
    }
}
