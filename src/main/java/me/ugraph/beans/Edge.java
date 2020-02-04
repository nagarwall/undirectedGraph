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

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public Integer getDest() {
        return dest;
    }

    public void setDest(Integer dest) {
        this.dest = dest;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
};