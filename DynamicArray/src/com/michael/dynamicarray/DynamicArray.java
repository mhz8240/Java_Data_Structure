package com.michael.dynamicarray;

import java.util.Arrays;

public class DynamicArray {
    private int[] intArray = null;
    private int capacity;
    private int size;
    private static final int minCapacity = 4;
    private static final int maxCapacity = 8;

    public DynamicArray() {
        this.capacity = 4;
        this.size = 0;
        this.intArray = new int[capacity];
    }
    public void add(int data) {
        if (size >= maxCapacity) {
            System.out.println("Out of capacity");
            return;
        }
        if (size >= capacity){
            capacity *= 2;
            int[] newIntArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newIntArray[i] = intArray[i];
            }
            intArray = newIntArray;
        }
        intArray[size] = data;
        size++;
    }
    public void insert(int index, int data) {
        if (size >= maxCapacity) {
            System.out.println("Out of capacity");
            return;
        }
        if (index > size || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }
        if (size >= capacity){
            capacity *= 2;
            int[] newIntArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newIntArray[i] = intArray[i];
            }
            intArray = newIntArray;
        }
        for (int i = size; i > index; i--) {
            intArray[i] = intArray[i - 1];
        }
        intArray[index] = data;
        size++;
    }

    public int get(int index) {
        return intArray[index];
    }

    public void remove(int index) {
        if (size <= minCapacity) {
            System.out.println("Too small capacity");
            return;
        }
        if (index > size || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            intArray[i] = intArray[i + 1];
        }
        intArray[size - 1] = 0;
        size--;
        if (size <= capacity / 4) {
            capacity /= 2;
            int[] newIntArray = new int[capacity];
            for (int i = 0; i < size; i++) {
                newIntArray[i] = intArray[i];
            }
            intArray = newIntArray;
        }

    }
    @Override
    public String toString() {
        return "DynamicArray{" +
                "intArray=" + Arrays.toString(intArray) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
