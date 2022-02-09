package com.ashx.gfg.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class Graph {
    int V;
    LinkedList<Edge>[] adj;
    Type type;

    Graph(int v) {
        this(v, Type.Undirected);
    }

    Graph(int v, Type type) {
        V = v;
        this.type = type;
        adj = new LinkedList[V];
        for (int i = 0; i < V; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        addEdge(src, dest, 0);
    }

    void addEdge(int src, int dest, int weight) {
        adj[src].add(new Edge(src, dest, weight));
        if (type == Type.Undirected) {
            adj[dest].add(new Edge(dest, src, weight));
        }
    }

    Edge[] getEdges() {
        return Arrays.stream(adj).flatMap(Collection :: stream).toArray(Edge[] :: new);
    }

    enum Type {
        Directed, Undirected
    }
}
