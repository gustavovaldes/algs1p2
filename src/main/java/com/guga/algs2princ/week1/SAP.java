package com.guga.algs2princ.week1;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Digraph;

/**
 * Created by guga
 */
public class SAP {

    private Digraph G;

    // constructor takes a digraph (not necessarily a DAG)
    public SAP(Digraph G) {
        this.G = new Digraph(G);
    }

    // length of shortest ancestral path between v and w; -1 if no such path
    public int length(int v, int w) {
        BreadthFirstDirectedPaths bfdV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfdW = new BreadthFirstDirectedPaths(G, w);
        int distance = Integer.MAX_VALUE;
        int commonAncestor = -1;
        for (int i = 0; i < G.V(); i++) {
            if (bfdV.hasPathTo(i) && bfdW.hasPathTo(i)) {
                int local = bfdV.distTo(i) + bfdW.distTo(i);
                if (local < distance) {
                    distance = local;
                    commonAncestor = i;
                }
            }
        }
        if (commonAncestor == -1) return commonAncestor;
        else return bfdV.distTo(commonAncestor) + bfdW.distTo(commonAncestor);
    }

    // a common ancestor of v and w that participates in a shortest ancestral path; -1 if no such path
    public int ancestor(int v, int w) {
        BreadthFirstDirectedPaths bfdV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfdW = new BreadthFirstDirectedPaths(G, w);
        int distance = Integer.MAX_VALUE;
        int commonAncestor = -1;
        for (int i = 0; i < G.V(); i++) {
            if (bfdV.hasPathTo(i) && bfdW.hasPathTo(i)) {
                int local = bfdV.distTo(i) + bfdW.distTo(i);
                if (local < distance) {
                    distance = local;
                    commonAncestor = i;
                }
            }
        }
        return commonAncestor;
    }

    // length of shortest ancestral path between any vertex in v and any vertex in w; -1 if no such path
    public int length(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths bfdV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfdW = new BreadthFirstDirectedPaths(G, w);
        int distance = Integer.MAX_VALUE;
        int commonAncestor = -1;
        for (int i = 0; i < G.V(); i++) {
            if (bfdV.hasPathTo(i) && bfdW.hasPathTo(i)) {
                int local = bfdV.distTo(i) + bfdW.distTo(i);
                if (local < distance) {
                    distance = local;
                    commonAncestor = i;
                }
            }
        }
        if (commonAncestor == -1) return commonAncestor;
        else return bfdV.distTo(commonAncestor) + bfdW.distTo(commonAncestor);
    }

    // a common ancestor that participates in shortest ancestral path; -1 if no such path
    public int ancestor(Iterable<Integer> v, Iterable<Integer> w) {
        BreadthFirstDirectedPaths bfdV = new BreadthFirstDirectedPaths(G, v);
        BreadthFirstDirectedPaths bfdW = new BreadthFirstDirectedPaths(G, w);
        int distance = Integer.MAX_VALUE;
        int commonAncestor = -1;
        for (int i = 0; i < G.V(); i++) {
            if (bfdV.hasPathTo(i) && bfdW.hasPathTo(i)) {
                int local = bfdV.distTo(i) + bfdW.distTo(i);
                if (local < distance) {
                    distance = local;
                    commonAncestor = i;
                }
            }
        }
        return commonAncestor;
    }

    // do unit testing of this class
    public static void main(String[] args) {

    }
}
