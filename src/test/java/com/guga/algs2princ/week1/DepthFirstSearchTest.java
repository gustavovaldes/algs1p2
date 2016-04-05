package com.guga.algs2princ.week1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by guga
 */
public class DepthFirstSearchTest {


    @Test
    public void test() {
        Graph G = new Graph(10);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(2, 4);
        G.addEdge(3, 6);
        G.addEdge(5, 6);
        G.addEdge(6, 4);
        G.addEdge(7, 8);
        G.addEdge(1, 3);
        G.addEdge(2, 6);
        G.addEdge(4, 2);

        System.out.println(G);

        DepthFirstSearch dfs = new DepthFirstSearch(G, 7);
        Assert.assertEquals(2,dfs.count());//2
        Assert.assertFalse(dfs.marked(3));//false
        Assert.assertTrue(dfs.marked(8));//true


    }
}
