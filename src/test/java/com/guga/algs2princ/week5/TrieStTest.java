package com.guga.algs2princ.week5;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by gvaldes
 */
public class TrieStTest {

    @Test
    public void test(){
        TrieST<Integer> trie =  new TrieST<>();
        trie.put("hola",4);
        trie.put("uno",2);
        trie.put("home",2);

        Assert.assertEquals(new Integer(4), trie.get("hola"));
        Assert.assertEquals(new Integer(2), trie.get("uno"));
        Assert.assertEquals(new Integer(2), trie.get("home"));
        Assert.assertNull(trie.get("holas"));
        Assert.assertTrue(trie.contains("hola"));
        Assert.assertFalse(trie.contains("hd"));

    }
}
