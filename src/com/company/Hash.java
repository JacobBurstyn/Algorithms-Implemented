package com.company;

import java.util.Random;

public class Hash {

    int size;
    KeyValuePair[] hash;
    int collisionCount;

    public Hash(int size) {
        this.size = size;
        hash = new KeyValuePair[size];
    }

    public class KeyValuePair{
        String key;
        int value;

        public KeyValuePair(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public int generateHash(String s){
        int hashcode = 5;
        for (char c: s.toCharArray()) {
            hashcode*= (c+3)^2;
        }
        return Math.abs(hashcode);
    }

    public void insertLinearProbe(String key, int value){

        int hashcode = generateHash(key);
        int i = hashcode % size;
        if(hash[i] != null){
            hash[i] = new KeyValuePair(key, value);
        }
        else{
            collisionCount++;
              // linear probe to next slot in array
            while (hash[i] != null){
                collisionCount++;
                i = (hashcode+1) % size;
            }
            int h =hashcode % size;
            hash[h] = new KeyValuePair(key, value);
        }
    }

    public int findLinearProbe(String key){
        int hashcode = generateHash(key);
        int j = hashcode % size;
        if(hash[j] == null){
            System.out.println("key not found");
            return -1;
        }
        for (int i = 0; i < collisionCount; i++) {
            j = hashcode % size;
            if(hash[j] == null){
                continue;
            }
            if(hash[j].key == key){
                return hash[hashcode % size].value;
            }
            hashcode++;
        }
        System.out.println("no key found");
        return -1;
    }

    public void insertQuadratic(String key, int value){

        int hashcode = generateHash(key);
        int i = hashcode % size;
        if(hash[i] != null){
            hash[i] = new KeyValuePair(key, value);
        }
        else{
            int j = 1;
            while (hash[(hashcode)%size] == null){
                collisionCount++;
                hashcode = hashcode + (7*j) + (11*(j^2));
                j++;
            }
            hash[hashcode % size] = new KeyValuePair(key, value);
        }
    }

    public int findQuadratic(String key){
        int hashcode = generateHash(key);
        int j = 1;
        for (int i = 0; i < collisionCount; i++) {
            if(hash[hashcode % size].key == key){
                return hash[hashcode % size].value;
            }
            hashcode = hashcode + (7*j) + (11*(j^2));
            j++;
        }

        System.out.println("no key found");
        return -1;
    }

    public void insertDoubleHash(String key, int value){

        int hashcode = generateHash(key);
        int i = hashcode % size;
        if(hash[i] != null){
            hash[i] = new KeyValuePair(key, value);
        }
        else{
            // double hash
            int j = 1;
            while (hash[(hashcode)%size] == null){
                collisionCount++;
                hashcode = hashcode + (hashcode*j);
                j++;
            }
            hash[hashcode % size] = new KeyValuePair(key, value);
        }
    }

    public int findDoubleHash(String key){
        int hashcode = generateHash(key);
        int j =1;
        for (int i = 0; i < collisionCount; i++) {
            if(hash[hashcode % size].key == key){
                return hash[hashcode % size].value;
            }
            hashcode = hashcode + (hashcode*j);
        }
        System.out.println("no key found");
        return -1;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Hash h = new Hash(20000);
        for (int i = 0; i < 10000; i++) {
            h.insertLinearProbe("jacobi", rand.nextInt(10000));
        }
        long start = System.currentTimeMillis();
        for (int i = 0; i <1000; i++) {
            i = h.findLinearProbe("jacob"+i);
        }

        System.out.println(System.currentTimeMillis()- start);
        Hash hquad = new Hash(20000);
        for (int i = 0; i < 10000; i++) {
            h.insertQuadratic("jacobi", rand.nextInt(10000));
        }

        long start1 = System.currentTimeMillis();
        for (int i = 0; i <1000; i++) {
            i = h.findQuadratic("jacob"+i);
        }

        System.out.println(System.currentTimeMillis()- start);


        Hash hdouble = new Hash(20000);
        for (int i = 0; i < 10000; i++) {
            h.insertDoubleHash("jacobi", rand.nextInt(10000));
        }
        long start2 = System.currentTimeMillis();
        for (int i = 0; i <1000; i++) {
            i = h.findDoubleHash("jacob"+i);
        }

        System.out.println(System.currentTimeMillis()- start);
    }

}
