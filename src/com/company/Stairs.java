package com.company;

import java.util.ArrayList;
import java.util.HashSet;

public class Stairs {


    public static int numWays(int n,int[] x, ArrayList<Integer> path){
        if(n==0 || n==1){
            if(n==1){
                path.add(1);
            }
            for (Integer i:path) {
                System.out.print(i);
            }
            System.out.println();
            return 1;
        }

        int total =0;
        for (int i: x
             ) {
            if(n-i>=0){
                ArrayList<Integer> myPath = new ArrayList<>(path);
                myPath.add(i);
                total +=numWays(n-i,x,myPath);
            }
        }
        return total;
    }

    public static int num_ways(int n, int[] x){
        int[] nums = new int[n+1];
        nums[0]= 1;
        for (int i = 1; i <= n; i++) {
            int total =0;
            for (int a: x) {
                if(i-a>=0){
                    total += nums[i-a];
                }
            }
            nums[i] =total;
        }
        return nums[n];
    }


    public static void main(String[] args) {
        System.out.println(num_ways(11, new int[]{2,1,5}));
    }

}
