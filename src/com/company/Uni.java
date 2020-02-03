package com.company;


import java.util.HashMap;
import java.util.HashSet;

public class Uni{


    public static int numWays(int k){
        int count = helper(k);
        return count;
    }

    public static int helper(int k){
        if(k==0){
            return 0;
        }
        if(k==1){
            return 1;
        }
        return helper(k-1) +1 + helper(k-2)+1;

    }

    public static int[] multiples(int[]nums){
        int j  = 1;
        int zeroCount=0;
        int resultWithOutAzero=1;
        for (int i:nums
             ) {
            if(i==0){
                zeroCount++;
                if(zeroCount==2){
                    return new int[nums.length];
                }
                resultWithOutAzero = j;
                j= j*i;
            }

        }


        int[] toreturn = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if(zeroCount==1){
                if(nums[i]==0){
                    toreturn[i] = resultWithOutAzero;

                }
            }
            if(nums[i] != 0){
                toreturn[i] = j / nums[i];
            }
        }
        return  toreturn;
    }

    public static void main(String[] args) {
        //System.out.println(numWays(3));
        int[] ints = new int[] {9,0,-2};
         int []  ints2  = multiples(ints);
        for (int i : ints2
             ) {
            System.out.println(i);
        }
    }

}

