package com.guga.algs2princ.week1;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by gvaldes
 * <p/>
 * Undirected Graph implementation using adjacency list representation
 */
public class Graph {

    private final int V;
    private int E;
    private List<Integer>[] vertices;

    public Graph(int V) { //create a V-vertex graph with no edges
        this.V = V;
        this.E = 0;
        vertices = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            vertices[i] = new ArrayList<Integer>();
        }
        /*for (List<Integer> v : vertices) {
            v = new ArrayList<Integer>();
        }*/
    }

    public Graph(InputStream in) { // read a graph from input stream in
        Scanner sc = new Scanner(in);
        // Read V and construct this graph.
        this.V = sc.nextInt();
        this.E = sc.nextInt(); // Read E

        vertices = new ArrayList[V];
        for (List<Integer> v : vertices) {
            v = new ArrayList<Integer>();
        }


        for (int i = 0; i < E; i++) { // Add an edge.
            int v = sc.nextInt(); // Read a vertex,
            int w = sc.nextInt(); // read another vertex,
            addEdge(v, w); // and add edge connecting them.
        }
    }

    public int V() { //number of vertices
        return V;
    }

    public int E() { //number of edges
        return E;
    }

    public void addEdge(int v, int w) { //add edge v-w to this graph
        vertices[v].add(w);
        vertices[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) { // vertices adjacent to v
        return vertices[v];
    }


    public int degree(int v) {
        int degree = 0;
        for (int w : adj(v)) degree++;
        return degree;
    }

    public int maxDegree() {
        int max = 0;
        for (int v = 0; v < V(); v++)
            if (degree(v) > max)
                max = degree(v);
        return max;
    }

    public int avgDegree() {
        return 2 * E() / V();
    }

    public int numberOfSelfLoops() {
        int count = 0;
        for (int v = 0; v < V(); v++)
            for (int w : adj(v))
                if (v == w) count++;
        return count / 2; // each edge counted twice
    }

    public String toString() {
        String s = V + " vertices, " + E + " edges\n";
        for (int v = 0; v < V; v++) {
            s += v + ": ";
            for (int w : this.adj(v))
                s += w + " ";
            s += "\n";
        }
        return s;
    }
}
