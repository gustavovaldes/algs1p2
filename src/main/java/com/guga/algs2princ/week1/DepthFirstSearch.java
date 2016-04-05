package com.guga.algs2princ.week1;

/**
 * Created by guga
 */
public class DepthFirstSearch {

    private boolean marked[];
    private int count;

    public DepthFirstSearch(Graph G, int v) {
        marked = new boolean[G.V()];
        dfs(G, v);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;
        for (int w : G.adj(v)) {
            if (!marked[w]) dfs(G, w);
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
