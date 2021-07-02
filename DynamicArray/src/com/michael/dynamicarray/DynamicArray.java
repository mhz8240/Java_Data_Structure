package com.michael.dynamicarray;

import java.util.Arrays;

public class DynamicArray {
    private String[] strArray = null;
    private int capacity;
    private int size;
    private static final int minCapacity = 4;
    private static final int maxCapacity = 8;

    public DynamicArray() {
        this.capacity = 4;
        this.size = 0;
        this.strArray = new String[capacity];
    }
    public void add(String data) {
        if (size >= maxCapacity) {
            System.out.println("Out of capacity");
            return;
        }
        if (size >= capacity){
            resize();
        }
        strArray[size] = data;
        size++;
    }
    public void insert(int index, String data) {
        if (size >= maxCapacity) {
            System.out.println("Out of capacity");
            return;
        }
        if (index > size || index < 0) {
            System.out.println("Index out of bounds");
            return;
        }
        if (size >= capacity){
            resize();
        }
        for (int i = size; i > index; i--) {
            strArray[i] = strArray[i - 1];
        }
        strArray[index] = data;
        size++;
    }

    public String get(int index) {
        return strArray[index];
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
            strArray[i] = strArray[i + 1];
        }
        strArray[size - 1] = null;
        size--;
        if (size <= capacity / 4) {
            capacity /= 2;
            String[] newIntArray = new String[capacity];
            for (int i = 0; i < size; i++) {
                newIntArray[i] = strArray[i];
            }
            strArray = newIntArray;
        }

    }
    public void set(int index, String data) {
        strArray[index] = data;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public int size() {
        return size;
    }
    public boolean contains(String data) {
        for (String i : strArray) {
            if (i == data) {
                return true;
            }
        }
        return false;
    }
    private void resize() {
        capacity *= 2;
        String[] newIntArray = new String[capacity];
        for (int i = 0; i < size; i++) {
            newIntArray[i] = strArray[i];
        }
        strArray = newIntArray;
    }
    @Override
    public String toString() {
        return "DynamicArray{" +
                "intArray=" + Arrays.toString(strArray) +
                ", capacity=" + capacity +
                ", size=" + size +
                '}';
    }
}
