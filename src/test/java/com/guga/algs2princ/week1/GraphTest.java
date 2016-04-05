package com.guga.algs2princ.week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

/**
 * Created by gvaldes
 */
public class GraphTest {

    @Test
    public void test() {
        Graph graph = new Graph(10);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(1, 8);
        graph.addEdge(2, 4);
        graph.addEdge(3, 9);
        graph.addEdge(7, 2);
        graph.addEdge(3, 2);

        System.out.println(graph.V()); //10
        System.out.println(graph.E()); //9
        System.out.println(graph.adj(3));//4
        System.out.println(graph.adj(6)); //0

        Assert.assertEquals(10, graph.V());
        Assert.assertEquals(9, graph.E());
        Iterable<Integer> iter = graph.adj(3);
        Assert.assertEquals(4, ((Collection) iter).size());
        Assert.assertTrue(((Collection) iter).contains(1));
        Assert.assertTrue(((Collection) iter).contains(4));
        Assert.assertTrue(((Collection) iter).contains(9));
        Assert.assertTrue(((Collection) iter).contains(2));
        Assert.assertFalse(((Collection) iter).contains(7));

        System.out.println(graph);

        System.out.println(graph.degree(3));//4
        System.out.println(graph.avgDegree());//1
        System.out.println(graph.adj(4));// 3 5 2
        System.out.println(graph.maxDegree());//4
        System.out.println(graph.numberOfSelfLoops());//0
    }
}
