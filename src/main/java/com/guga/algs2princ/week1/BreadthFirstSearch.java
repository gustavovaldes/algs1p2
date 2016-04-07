package com.guga.algs2princ.week1;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by guga
 */
public class BreadthFirstSearch {

    private boolean[] marked;
    private int[] edgeTo;

    private void bfs(Graph G, int v) {
        Deque<Integer> queue = new LinkedList<Integer>();
        marked[v] = true;
        queue.add(v);
        while (queue.size() > 0) {
            int node = queue.poll();
            for (Integer w : G.adj(node)) {
                if (!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = node;
                    queue.push(w);
                }
            }
        }

    }

    public static void main(String[] args) {

    }
}
