package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Radix {
    ArrayList<Integer> numbers;

    ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(10);


    public Radix(ArrayList<Integer> nums){
        for (int i = 0; i <10; i++) {
            buckets.add(new ArrayList<Integer>());
        }
        numbers = nums;
    }

    public  ArrayList<Integer> radixSort(){
        int max = 0;
        for (Integer a: numbers) {
            if (a > max) {
                max = a;
            }
        }
        for (int div = 1; div<=max; div*=10) {
            for (int i = 0; i < numbers.size() ; i++) {
                Integer num =numbers.get(i);
                int digit  = (num/div) % 10;
                buckets.get(digit).add(num);
            }
            numbers.clear();

            for (ArrayList<Integer> a : buckets) {
                for (Integer i: a) {
                    numbers.add(i);
                }
                a.clear();
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>(1000);
        Random rand = new Random();

        for (int i = 0; i < 1000; i++) {
            numbers.add(rand.nextInt(200));
        }
        Radix r = new Radix(numbers);
        long start = System.currentTimeMillis();
        ArrayList<Integer> results = r.radixSort();
        long total = System.currentTimeMillis() - start;
        System.out.println("time is" + total );


        long start2 = System.currentTimeMillis();
        numbers.sort(Integer::compareTo);
        long total2 = System.currentTimeMillis() - start2;
        System.out.println("time is" + total2 );

//        for (Integer i : results) {
//            System.out.println(i);
//        }
    }
}



