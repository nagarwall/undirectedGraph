package me.ugraph;
import me.ugraph.beans.Edge;
import me.ugraph.beans.UndirectedGraph;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class GraphController {

    UndirectedGraph undirectedGraph = UndirectedGraph.getInstance();

    @PostMapping("/connectNodes")
    public String connectNodes(@RequestBody Map<String, String> body) {
        int node1 = Integer.parseInt(body.get("Node1"));
        int node2 = Integer.parseInt(body.get("Node2"));
        int weight = Integer.parseInt(body.get("Weight"));
        String status = undirectedGraph.connectNodes(node1, node2, weight);
        return status;
    }

    @PostMapping("/updateWeight")
    public String updateWeight(@RequestBody Map<String, String> body) {
        int node1 = Integer.parseInt(body.get("Node1"));
        int node2 = Integer.parseInt(body.get("Node2"));
        int weight = Integer.parseInt(body.get("Weight"));
        String status = undirectedGraph.updateWeight(node1, node2, weight);
        return status;
    }

    @PostMapping("/initGraph")
    public String initGraph(@RequestBody UndirectedGraphBean graph) {
        Integer vertex = graph.getV();
        Integer edge = graph.getE();
        List<Edge> edges = graph.getEdges();
        undirectedGraph.setV(vertex);
        undirectedGraph.setE(edge);
        undirectedGraph.setEdge(edges);
        return "200";
    }

    @PostMapping("/newNode")
    public String newNode(@RequestBody UndirectedGraphBean graph) {
        Integer vertex = graph.getV();
        Integer edge = graph.getE();
        List<Edge> edges = graph.getEdges();
        String status = undirectedGraph.newNode(vertex, edge, edges);
        return status;
    }

    @PostMapping("/removeNode")
    public String removeNode(@RequestBody Map<String, String> body) {
        int node = Integer.parseInt(body.get("Node"));
        String status = undirectedGraph.removeNode(node);
        return status;
    }

    @GetMapping("/getGraph")
    public UndirectedGraphBean getGraph() {
        UndirectedGraphBean result = new UndirectedGraphBean(undirectedGraph.getV(), undirectedGraph.getE(), undirectedGraph.getEdge());

        return result;
    }

    @GetMapping("/getMST")
    public String getMST() {
        return undirectedGraph.getMST();
    }
}