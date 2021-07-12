package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        BinarySearchTree bst = new BinarySearchTree();
        bst.add(5,5383898);
        bst.add(6,5374690);
        bst.add(3,5383892);
        System.out.println(bst.get(3, bst.root));
        bst.inOrderTraversal(bst.root);
        bst.remove(5);
        System.out.println();
        bst.inOrderTraversal(bst.root);
    }
}
