package com.guga.algs2princ.week1;

import org.junit.Test;

import java.util.Scanner;

/**
 * Created by gvaldes
 */
public class WordNetTest {

    @Test
    public void test1() {
        Scanner sc = new Scanner("/week1/synsets15.txt");
        while(sc.hasNext()){
            System.out.println(sc.next());
        }
        //System.out.println(new Scanner("week1/synsets15.txt").next());
        WordNet wordNet = new WordNet("/week1/synsets15.txt", "/week1/hypernyms15Tree.txt");
        System.out.println(wordNet.distance("h","i"));
        System.out.println(wordNet.sap("h","i"));
    }

    @Test
    public void test2() {
        //System.out.println(new Scanner("week1/synsets15.txt").next());
        WordNet wordNet = new WordNet("/week1/synsets15.txt", "/week1/hypernyms15Path.txt");
        System.out.println(wordNet.distance("a","b"));
        System.out.println(wordNet.sap("a","b"));
    }
}
