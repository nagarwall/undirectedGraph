package me.ugraph.beans;

public class Edge implements Comparable<Edge> {
    public Integer src;
    public Integer dest;
    public Integer weight;

    public Edge() {
    }

    public Edge(Integer src, Integer dest, Integer weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    // Comparator function used for sorting edges
    // based on their weight
    public int compareTo(Edge compareEdge) {
        return this.weight - compareEdge.weight;
    }
};