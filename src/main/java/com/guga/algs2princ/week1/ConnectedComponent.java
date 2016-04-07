package com.guga.algs2princ.week1;

/**
 * Created by guga
 */
public class ConnectedComponent {


    private boolean[] marked;
    private int[] cc;
    private int component;

    public ConnectedComponent(Graph G) {
        marked = new boolean[G.V()];
        cc = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]) {
                dfs(G, i);
                component++;
            }
        }

    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        cc[v] = component;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return cc[v] == cc[w];
    }

    /**
     * number of components
     */
    public int count() {
        return component;
    }

    public int id(int v) {
        return 0;
    }
}
