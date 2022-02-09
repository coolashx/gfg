package com.ashx.gfg.graph;

import java.util.Arrays;
import java.util.Stack;

/**
 * To find Strongly Connected Components.
 * A strongly connected component is a component where all vertices of that component
 * are reachable from all other vertices of that component.
 */
public class TarjanStronglyConnectedComponents {
    public static void main(String[] args) {
        SCCGraph g = new SCCGraph(5, Graph.Type.Directed);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        printSCC(g);
    }

    public static void printSCC(SCCGraph graph) {
        int V = graph.V;
        int[] disc = new int[V];
        int[] low = new int[V];
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);

        boolean[] stackMember = new boolean[V];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (disc[i] == -1) {
                SCCUtil(i, low, disc, stackMember, st, graph);
            }
        }
    }

    private static void SCCUtil(int u, int[] low, int[] disc, boolean[] stackMember, Stack<Integer> st, SCCGraph graph) {
        disc[u] = low[u] = graph.time;
        graph.time++;
        stackMember[u] = true;
        st.push(u);

        int n;
        for (Edge edge : graph.adj[u]) {
            n = edge.dest;
            if (disc[n] == -1) {
                SCCUtil(n, low, disc, stackMember, st, graph);
                low[u] = Math.min(low[u], low[n]);
            } else if (stackMember[n]) {
                low[u] = Math.min(low[u], disc[n]);
            }
        }

        int w = -1;
        if (low[u] == disc[u]) {
            while (w != u) {
                w = st.pop();
                System.out.print(w + " ");
                stackMember[w] = false;
            }
            System.out.println();
        }
    }

    static class SCCGraph extends Graph {
        int time = 0;

        SCCGraph(int v, Type type) {
            super(v, type);
        }
    }
}
