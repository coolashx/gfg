package com.ashx.gfg.graph;

import java.util.Arrays;

/**
 * To find the Minimum Spanning Tree.
 * Minimum Spanning Tree is graph where all vertices V are connected with V-1 edges
 * with the lowest weight.
 */
public class PrimMinimumSpanningTree {
    public static void main(String[] args) {
        System.out.println("Weight of  Minimum Spanning Tree: " + primMST(GraphUtil.getUndirectedWeightedGraph()));
    }

    public static int primMST(int[][] graph) { // Theta (V^2)
        int V = graph.length, res = 0;
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        boolean[] mSet = new boolean[V];
        for (int count = 0; count < V; count++) {
            int u = -1;
            for (int i = 0; i < V; i++) {
                if (!mSet[i] && (u == -1 || key[i] < key[u])) {
                    u = i;
                }
            }
            mSet[u] = true;
            res += key[u];
            for (int v = 0; v < V; v++) {
                if (!mSet[v] && graph[u][v] != 0 && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        return res;
    }
}
