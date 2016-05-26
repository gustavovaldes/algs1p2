package com.guga.algs2princ.week5;

/**
 * Created by gvaldes
 */
public class TrieST<Value> {
    private static final int R = 256;
    private Node root = new Node();

    public void put(String key, Value value) {
        root = put(root, key, value, 0);
    }

    private Node put(Node node, String key, Value value, int index) {
        if (node == null) {
            node = new Node();
        }
        if (index == key.length()) {
            node.value = value;
            return node;
        }
        char c = key.charAt(index);
        node.next[c] = put(node.next[c], key, value, ++index);
        return node;
    }

    public Value get(String key) {
        Node node = get(root, key, 0);
        if (node == null) return null;
        return (Value) node.value;
    }

    private Node get(Node node, String key, int index) {
        if (node == null) return null;
        if (index == key.length()) return node;
        char c = key.charAt(index);
        return get(node.next[c], key, ++index);

    }

    public boolean contains(String key) {
        return get(key) != null;
    }

    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }
}
