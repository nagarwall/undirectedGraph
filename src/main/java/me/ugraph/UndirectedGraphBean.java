package me.ugraph;
import me.ugraph.beans.Edge;
import java.util.List;

public class UndirectedGraphBean {
    private Integer v;
    private Integer e;
    private List<Edge> edges;

    public UndirectedGraphBean() {
    }

    public UndirectedGraphBean(Integer v, Integer e, List<Edge> edges) {
        this.v = v;
        this.e = e;
        this.edges = edges;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public Integer getE() {
        return e;
    }

    public void setE(Integer e) {
        this.e = e;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void setEdges(List<Edge> edges) {
        this.edges = edges;
    }
}
