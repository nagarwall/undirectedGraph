package me.ugraph.beans;
// Java program for Kruskal's algorithm to find Minimum
// Spanning Tree of a given connected, undirected and weighted graph

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UndirectedGraph {

    static UndirectedGraph graph = null;
    private static UndirectedGraph instance = null;
    int V = 0;
    int E = 0;    // V-> no. of vertices & E->no.of edges
    Edge edge[]; // collection of all edges

    UndirectedGraph() {
        int V = 0;
        int E = 0;    // V-> no. of vertices & E->no.of edges
        edge = new Edge[E];
    }

    // A class to represent a graph edge 

    public int getV() {return V;}
    public void setV(int v) {V = v;}

    public int getE() {return E;}
    public void setE(int e) {E = e;}

    public List<Edge> getEdge() {
        List<Edge> retE = new ArrayList<Edge>();
        for (int i=0; i<E; i++)
        {
            retE.add(graph.edge[i]);
        }
        return retE;
    }

    public  void setEdge(List<Edge> e) {
        edge = new Edge[E];
        for (int i = 0; i < E; ++i) {
            edge[i] = new Edge();
           edge[i] = e.get(i);
        }
    }

    // Creates a graph with V vertices and E edges
    UndirectedGraph(int v, int e) {
        V = v;
        E = e;
        //new Edge[E];
        for (int i = 0; i < e; ++i)
            edge[i] = new Edge();
    }

    public static UndirectedGraph getInstance() {
        if (instance == null) {
            instance = new UndirectedGraph();
            graph = instance;
        }
        return instance;
    }

    // A utility function to find set of an element i 
    // (uses path compression technique) 
    int find(subset subsets[], int i) {
        // find root and make root as parent of i (path compression) 
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);

        return subsets[i].parent;
    }

    // A function that does union of two sets of x and y 
    // (uses union by rank) 
    void Union(subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        // Attach smaller rank tree under root of high rank tree 
        // (Union by Rank) 
        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;

            // If ranks are same, then make one as root and increment
            // its rank by one
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    // The main function to construct MST using Kruskal's algorithm 
    public String KruskalMST() {
        Edge result[] = new Edge[V];  // Tnis will store the resultant MST 
        int e = 0;  // An index variable, used for result[] 
        int i = 0;  // An index variable, used for sorted edges 
        for (i = 0; i < V; ++i)
            result[i] = new Edge();

        // Step 1:  Sort all the edges in non-decreasing order of their 
        // weight.  If we are not allowed to change the given graph, we 
        // can create a copy of array of edges 
        Arrays.sort(edge);

        // Allocate memory for creating V ssubsets 
        subset subsets[] = new subset[V];
        for (i = 0; i < V; ++i)
            subsets[i] = new subset();

        // Create V subsets with single elements 
        for (int v = 0; v < V; ++v) {
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        i = 0;  // Index used to pick next edge 

        // Number of edges to be taken is equal to V-1 
        while (e < V - 1) {
            // Step 2: Pick the smallest edge. And increment  
            // the index for next iteration 
            Edge next_edge = new Edge();
            next_edge = edge[i++];

            int x = find(subsets, next_edge.src);
            int y = find(subsets, next_edge.dest);

            // If including this edge does't cause cycle, 
            // include it in result and increment the index  
            // of result for next edge 
            if (x != y) {
                result[e++] = next_edge;
                Union(subsets, x, y);
            }
            // Else discard the next_edge 
        }

        // print the contents of result[] to display 
        // the built MST
        String str = new String();

        System.out.println("Following are the edges in " +
                "the constructed MST");
        str = "Following are the edges in the constructed MST : \n";
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].src + " -- " +
                    result[i].dest + " == " + result[i].weight);
            str = str + result[i].src + " -- " + result[i].dest + " == " + result[i].weight + " \n";
        }

        return str;
    }

    public String initGraph(int v, int e) {
        if (graph == null) {
            graph = new UndirectedGraph(v, e);
            return "201";
        } else
            return "400"; // return error
    }

    public String printGraph() {
        String ret = new String();
        ret = ret + "Node : " + graph.V + "\n";
        ret = ret + "Vertex : " + graph.E + "\n";
        ret = ret + "Edges : \n";
        for (int i = 0; i < graph.E; ++i) {
            ret = ret + "Src : " + graph.edge[i].src + "  Dst : " + graph.edge[i].dest + "  Weight : " + graph.edge[i].weight + "\n";
        }
        System.out.println(graph.V);
        System.out.println(graph.E);
        return ret;
    }

    public String connectNodes(int node1, int node2, int weight) {
        if ((node1 <= graph.V) && (node2 <= graph.V)) {
            if (node1 != node2) {
                if (weight >= 0 && weight <= 100) {
                    for (int i = 0; i < graph.E; i++) {
                        if (graph.edge[i].src == node1 && graph.edge[i].dest == node2) {
                            return "400 - nodes already connected";
                        }
                    }
                    Edge e[] = graph.edge;
                    graph.edge = new Edge[graph.E + 1];
                    for (int i =0; i< graph.E; i++){
                        graph.edge[i] = e[i];
                    }
                    graph.edge[graph.E] = new Edge();
                    graph.edge[graph.E].src = node1;
                    graph.edge[graph.E].dest = node2;
                    graph.edge[graph.E].weight = weight;
                    graph.E++;
                    return "201";
                } else
                    return "weight value is out of bound"; //return weight value is out of bound
            } else
                return "node1 and node 2 are same"; //return node1 and node 2 are same
        } else
            return "node 1 or node 2 are beyond limit"; //return node 1 or node 2 are beyond limit
    }


    public String newNode(int node, int edge, List<Edge> edges) {

        if (node == (graph.V + 1))
        {
            for (int i = 0; i < graph.E; i++) {
                if ((graph.edge[i].src == node) || (graph.edge[i].dest == node)) {
                    return "400 - Node already exists";
                }
            }

            Edge e[] = graph.edge;
            graph.edge = new Edge[graph.E + edge];

            int index = 0;
            for (int i = 0; i < graph.E; i++) {
                graph.edge[index++] = e[i];
            }
            for (int i = 0; i < edge; i++) {
                graph.edge[index++] = edges.get(i);
            }
            graph.E = graph.E + edge;
            graph.V++;
            return "200";
        } else {
            return "400 - node is not in order";
        }
    }


    public String removeNode(int node) {
        int removeEdge = 0;
        if (node <= graph.V) {
            for (int i = 0; i < graph.E; i++) {
                if ((graph.edge[i].src == node) || (graph.edge[i].dest == node)) {
                    graph.edge[i] = null;
                    removeEdge++;
                }
            }

            Edge e[] = graph.edge;
            graph.edge = new Edge[graph.E - removeEdge];

            int index = 0;
            for (int i =0; i< graph.E; i++){
                if (e[i] != null) {
                    graph.edge[index++] = e[i];
                }
            }
            graph.E = graph.E - removeEdge;
            graph.V--;
            return "200";
        } else
            return "node is beyond limit"; //return node 1 or node 2 are beyond limit
    }



    public String updateWeight(int node1, int node2, int weight) {
        boolean found = false;
        if ((node1 <= graph.V) && (node2 <= graph.V)) {
            if (node1 != node2) {
                if (weight >= 0 && weight <= 100) {
                    for (int i = 0; i < graph.E; ++i) {
                        if (graph.edge[i].src == node1 && graph.edge[i].dest == node2) {
                            graph.edge[i].weight = weight;
                            found = true;
                            return "200 - updated weight"; //success
                        }
                        i++;
                    }
                    if (!found) {
                        return "error that edge is not found"; //return error that edge is not found
                    }
                } else
                    return "weight value is out of bound"; //return weight value is out of bound
            } else
                return "node1 and node 2 are same"; //return node1 and node 2 are same
        } else
            return "node 1 or node 2 are beyond limit"; //return node 1 or node 2 are beyond limit

        return "200";
    }

    public String getMST() {
        return graph.KruskalMST();
    }

    // A class to represent a subset for union-find
    class subset {
        int parent, rank;
    }
} 