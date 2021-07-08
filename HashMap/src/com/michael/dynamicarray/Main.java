package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyHashTable myHashTable = new MyHashTable();
        myHashTable.put("John", "382-0879");
        myHashTable.put("Jane", "356-6215");
        myHashTable.put("Joe", "796-5423");
        System.out.println(myHashTable.toString());
        System.out.println(myHashTable.get("John"));
        System.out.println(myHashTable.get("john"));
    }
}
