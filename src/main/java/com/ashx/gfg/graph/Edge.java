package com.ashx.gfg.graph;

public class Edge implements Comparable<Edge> {
    int src;
    int dest;
    int weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public Edge(int src, int dest) {
        this.src = src;
        this.dest = dest;
    }

    @Override
    public int compareTo(Edge e) {
        return Integer.compare(this.weight, e.weight);
    }
}
