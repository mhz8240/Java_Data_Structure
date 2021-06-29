package com.michael.dynamicarray;

public class Main {

    public static void main(String[] args) {
        // write your code here
        DynamicArray da = new DynamicArray();
        da.add(3);
        da.add(4);
        da.add(5);
        da.insert(1,6);
        da.insert(3,7);
        System.out.println("Index 1: " + da.get(1));
        System.out.println("Index 2: " + da.get(2));
        System.out.println(da);
        da.add(3);
        da.add(4);
        da.add(5);
        da.add(3);
        da.add(10);
        da.remove(2);
        da.remove(0);
        da.remove(1);
        System.out.println(da);

    }
}