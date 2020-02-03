package com.company;

import java.util.ArrayList;
import java.util.Random;

// solves subset sum using genetic algorithm

public class GA {
    int percentError =10;
    int target;
    int[] nums;
    Random rand = new Random();
    ArrayList<boolean[]> nextGeneration = new ArrayList<>();
    ArrayList<boolean[]> generation1;

    public GA(int[] nums, int target){
        this.nums = nums;
        this.target = target;
        generation1= new ArrayList<>(nums.length);
        firstGen();
    }



    private void firstGen(){
        for (boolean[] b :generation1) {
            for (boolean a: b) {
                a = rand.nextBoolean();
            }
        }
    }

    //evalutates and adds solutions close to the target
    public void evaluate(boolean[] b){
        int total=0;
        for (int i = 0; i < nums.length; i++) {
            if(b[i]){
                total+=nums[i];
            }
        }
        if(Math.abs((total-target)/target) < percentError){
            nextGeneration.add(b);
        }
        if(total-target ==0 ){
            System.out.println("solved");
            for (boolean a: b
                 ) {
                System.out.println(b+", ");
            }
        }
    }

    // duplicates the solutions in the next generation to fill up a new generation they will then be mutated
    public void finishGen(){
        for (int i = 0; i < 20-nextGeneration.size() ; i++) {
            nextGeneration.add(nextGeneration.get(i));
        }
    }

    public void mutation(){
        for (boolean[] b: nextGeneration) {
            for (boolean a: b) {
                if(rand.nextInt(10)>7){
                    a = !a;
                }
            }
        }
    }

    public void setNextGeneration(){
        percentError = percentError/2;
        for (boolean[] b: generation1) {
            evaluate(b);
        }
        finishGen();
        mutation();
        generation1 = nextGeneration;
        nextGeneration.clear();
    }

    public void solve(){
        for (int i = 0; i < 10 ; i++) {
            setNextGeneration();
        }
        for (boolean[] a: generation1
             ) {
            System.out.println("close  ");
            for (boolean b:a
                 ) {
                System.out.println(b);
            }
        }
    }

    public static void main(String[] args) {
        int[] ints ={5,3,8,33,9,22,4,56};
        GA ga= new GA(ints, 28);
        ga.solve();
    }

}
