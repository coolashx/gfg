package com.ashx.gfg.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Articulation Point is a vertex in a graph which after removal
 * divides graph in multiple (two or more) disconnected components.
 */
public class ArticulationPoint {
    public static void main(String[] args) {
        APGraph g = new APGraph(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        int[] aps = getArticulationPoints(g);
        System.out.println("Articulation points : " + Arrays.toString(aps));
    }

    public static int[] getArticulationPoints(APGraph graph) {
        int V = graph.V;
        boolean[] visited = new boolean[V];
        int[] disc = new int[V];
        int[] low = new int[V];
        boolean[] ap = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, APGraph.NIL);

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                APUtil(i, visited, disc, low, parent, ap, graph);
            }
        }

        List<Integer> aps = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (ap[i]) {
                aps.add(i);
            }
        }
        return aps.stream().mapToInt(Integer :: intValue).toArray();
    }

    private static void APUtil(int u, boolean[] visited, int[] disc,
                               int[] low, int[] parent, boolean[] ap, APGraph graph) {
        int children = 0;
        visited[u] = true;
        disc[u] = low[u] = ++graph.time;

        for (Edge edge : graph.adj[u]) {
            int v = edge.dest;
            if (!visited[v]) {
                children++;
                parent[v] = u;
                APUtil(v, visited, disc, low, parent, ap, graph);

                low[u] = Math.min(low[u], low[v]);
                if (parent[u] == APGraph.NIL && children > 1) {
                    ap[u] = true;
                }
                if (parent[u] != APGraph.NIL && low[v] >= disc[u]) {
                    ap[u] = true;
                }
            } else if (v != parent[u]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }

    static class APGraph extends Graph {
        static final int NIL = -1;

        int time = 0;

        APGraph(int v) {
            super(v);
        }
    }
}
