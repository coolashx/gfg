package com.ashx.gfg.disjoint;

import com.ashx.gfg.graph.Edge;

import java.util.Arrays;

/**
 * For finding weight of Minimum Spanning Tree (MST)
 */
public class KruskalAlgorithmMST {
    int[] parent;
    int[] rank;

    public KruskalAlgorithmMST(int V) {
        parent = new int[V];
        rank = new int[V];
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }
    }

    public static int kruskal(int V, Edge[] edges) { // O(E * log E)
        KruskalAlgorithmMST tree = new KruskalAlgorithmMST(V);
        Arrays.sort(edges);
        int res = 0;

        for (int i = 0, s = 0; s < V - 1; i++) {
            Edge e = edges[i];
            int x = tree.find(e.getSrc());
            int y = tree.find(e.getDest());
            if (x != y) {
                res += e.getWeight();
                tree.union(x, y);
                s++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int V = 5;
        Edge[] edges = {
                new Edge(0, 1, 10),
                new Edge(0, 2, 8),
                new Edge(1, 2, 5),
                new Edge(1, 3, 3),
                new Edge(2, 3, 4),
                new Edge(2, 4, 12),
                new Edge(3, 4, 15)
        };
        int mstWeight = kruskal(V, edges);
        System.out.println(mstWeight);
    }

    public int find(int v) {
        if (parent[v] == v) {
            return v;
        } else {
            return find(parent[v]);
        }
    }

    public void union(int x, int y) {
        int x_rep = find(x);
        int y_rep = find(y);
        if (x_rep == y_rep) {
            return;
        }
        if (rank[x_rep] < rank[y_rep]) {
            parent[x_rep] = y_rep;
        } else if (rank[x_rep] > rank[y_rep]) {
            parent[y_rep] = x_rep;
        } else {
            parent[y_rep] = x_rep;
            rank[x_rep]++;
        }
    }
}
