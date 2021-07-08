package com.michael.dynamicarray;

import java.util.Arrays;

public class MyHashTable {
    private Data[] data;
    private int INITIAL_VALUE = 16;

    public MyHashTable() {
        this.data = new Data[INITIAL_VALUE];
    }

    private class Data {
        String key;
        String value;
        Data next;
        public Data(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }
    public void put(String key, String value) {
        int index = getIndex(key);
        if (data[index] == null) {
            data[index] = new Data(key, value);
            return;
        }
        Data currentData = data[index];
        while (currentData.next != null) {
            currentData = currentData.next;
        }
        currentData.next = new Data(key, value);
    }
    private int getIndex(String key) {
        return (key.hashCode() & 0x7fffffff) % INITIAL_VALUE;
    }

    @Override
    public String toString() {
        return "MyHashTable{" +
                "data=" + Arrays.toString(data) +
                ", INITIAL_VALUE=" + INITIAL_VALUE +
                '}';
    }

    public String get(String key) {
        int index = getIndex(key);
        if (data[index] == null) {
            System.out.println("Can't find the given key");
            return null;
        }
        Data currentData = data[index];
        while (currentData != null) {
            if (currentData.key.equals(key)) {
                return currentData.value;
            }
            currentData = currentData.next;
        }
        System.out.println("Can't find the given key");
        return null;
    }
}
