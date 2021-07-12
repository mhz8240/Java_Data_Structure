package com.michael.dynamicarray;

public class BinarySearchTree {
    class Node {
        private int key;
        private int value;
        private Node left;
        private Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public Node getMin(Node node) {
            if (node.left == null) {
                return node;
            }
            return getMin(node.left);
        }
        public Node getMax(Node node) {
            if (right == null) {
                return node;
            }
            return getMin(right);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    Node root = null;
    public void add(int key, int value) {
        root = add(key, value, root);
    }
    private Node add(int key, int value, Node node) {
        if (node == null) {
            return new Node(key, value);
        }

        if (key < node.key) {
            node.left = add(key, value, node.left);
        }
        if (key > node.key) {
            node.right = add(key, value, node.right);
        }
        return node;
    }

    public Node get(int key, Node node) {
        if (node == null) {
            System.out.println("Couldn't find the given key");
            return null;
        }
        if (key == node.key) {
            return node;
        }
        if (key < node.key) {
            return get(key, node.left);
        }
        if (key > node.key) {
            return get(key, node.right);
        }
        return null;
    }
    public void remove(int key) {
        root = remove(key, root);
    }
    private Node remove(int key, Node node) {
        if (node == null) {
            System.out.println("Couldn't find the given key");
            return null;
        }
        if (key < node.key) {
            node.left = remove(key, node.left);
        }
        else if (key > node.key) {
            node.right =  remove(key, node.right);
        }
        else {
            if (node.left == null && node.right == null) {
                return null;
            }
            else if (node.left == null) {
                return node.right;
            }
            else if (node.right == null) {
                return node.left;
            }
            else {
                Node minRight = node.getMin(node.right);
                node.key = minRight.key;
                node.value = minRight.value;
                node.right = remove(node.key, node.right);
            }
        }
        return node;
    }

    public void inOrderTraversal(Node node) {
        if (node.left != null) {
            inOrderTraversal(node.left);
        }
        System.out.print(node + ", ");
        if (node.right != null) {
            inOrderTraversal(node.right);
        }
    }
}
