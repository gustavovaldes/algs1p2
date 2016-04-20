package com.guga.algs2princ.week1;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.In;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guga
 */
public class WordNet {


    private Map<String, Integer> map = new HashMap<>();//private Map<Integer, Set<String>> mapIdToNoun = new HashMap<>();
    private Digraph G;
    private SAP sap;

    /*constructor takes the name of the two input files
     *linearithmic time (or better) in the input size.
     */
    public WordNet(String synsets, String hypernyms) {
        In in = new In(synsets);
        int counter = 0;
        while (in.hasNextLine()) {
            String[] values = in.readLine().split("\\,");
            String[] nouns = values[1].split(" ");
            for (int i = 0; i < nouns.length; i++) {
                if(!map.containsKey(nouns[i])){
                    map.put(nouns[i],Integer.parseInt(values[0]));
                    counter++;
                }
            }
            //map.put(values[1], Integer.parseInt(values[0]));
        }
        G = new Digraph(counter);

        In in2 = new In(hypernyms);
        while (in2.hasNextLine()) {
            String[] values = in2.readLine().split("\\,");
            for (int i = 1; i < values.length; i++) {
                G.addEdge(Integer.parseInt(values[i - 1]), Integer.parseInt(values[i]));
                //System.out.println("edge:"+ values[i-1]+ " ->" + values[i]);
            }
        }

        sap = new SAP(G);
        //System.out.println(G);
    }

    // do unit testing of this class
    public static void main(String[] args) {

    }

    // returns all WordNet nouns
    public Iterable<String> nouns() {
        return map.keySet();
    }

    /* is the word a WordNet noun?
     * logarithmic time or better
     **/
    public boolean isNoun(String word) {
        return map.containsKey(word);
    }

    /* distance between nounA and nounB (defined below)
     * linear time
     * */
    public int distance(String nounA, String nounB) {
        return sap.length(map.get(nounA), map.get(nounB));
    }

    /**
     * a synset (second field of synsets.txt) that is the common ancestor of nounA and nounB
     * in a shortest ancestral path (defined below)
     * linear time
     */
    public String sap(String nounA, String nounB) {
        int ancestor = sap.ancestor(map.get(nounA), map.get(nounB));
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            if (stringIntegerEntry.getValue() == ancestor) return stringIntegerEntry.getKey();
        }
        return "error";
    }
}
