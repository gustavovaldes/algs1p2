package com.guga.algs2princ.week1;

import org.junit.Assert;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by gvaldes
 */
public class WordNetTest {


    @Test
    public void testHypernyms() {
        WordNet wordNet = new WordNet("/week1/synsets.txt", "/week1/hypernyms.txt");
        Assert.assertEquals(11,wordNet.distance("genus_Actinia", "weakling"));
        Assert.assertEquals(3,wordNet.distance("Apios_americana", "touch-me-not"));

    }

    @Test
    public void testHypernyms15Tree() {
        WordNet wordNet = new WordNet("/week1/synsets15.txt", "/week1/hypernyms15Tree.txt");
        System.out.println(wordNet.distance("h","i"));
        System.out.println(wordNet.sap("h","i"));
    }

    @Test
    public void testHypernyms15Path() {
        WordNet wordNet = new WordNet("/week1/synsets15.txt", "/week1/hypernyms15Path.txt");
        System.out.println(wordNet.distance("a","b"));
        System.out.println(wordNet.sap("a", "b"));
    }

    @Test
    public void testHypernyms6TwoAncestors() {
        WordNet wordNet = new WordNet("/week1/synsets6.txt", "/week1/hypernyms6TwoAncestors.txt");
        //Assert.assertEquals(4, wordNet.distance("a", "c"));
        Assert.assertEquals("a", wordNet.sap("a", "c"));
    }

    @Test
    public void testHypernyms8WrongBFS() {
        WordNet wordNet = new WordNet("/week1/synsets8.txt", "/week1/hypernyms8WrongBFS.txt");
        Assert.assertEquals(2, wordNet.distance("a", "d"));
        Assert.assertEquals(2, wordNet.distance("a", "d"));
    }

    @Test
    public void testHypernyms8ModTree() {
        WordNet wordNet = new WordNet("/week1/synsets8.txt", "/week1/hypernyms8ManyAncestors.txt");
        Assert.assertEquals(1, wordNet.distance("a", "d"));
    }


}
