package com.company;

import java.util.Arrays;

public class Algorithm {



    public static int[] findClosestPair(int[] a, int[] b, int target){
        int offFromTarget = target;
        int[] closestPair = new int[2];
        for (int i: a) {
            for (int j: b) {
                int value = Math.abs(i+j - target);
                if(value == 0){
                    System.out.println(i+"+"+j);
                    closestPair[0] = i;
                    closestPair[1] = j;
                    return closestPair;
                }
                if(value < offFromTarget){
                    offFromTarget = Math.abs(i+j - target);
                    closestPair[0] = i;
                    closestPair[1] = j;
                }
            }
        }
        return closestPair;
    }

    public static int[] findClosestPair2(int[] a1, int[] a2, int target){
        int offFromTarget = target;
        int[] a1Sorted = Arrays.copyOf(a1, a1.length);
        Arrays.sort(a1Sorted);
        int[] a2Sorted = Arrays.copyOf(a2, a2.length);
        Arrays.sort(a2Sorted);

        int i = 0;
        int j = a2Sorted.length - 1;
        int smallestDiff = Math.abs(a1Sorted[0] + a2Sorted[0] - target);
        int[] closestPair = {a1Sorted[0], a2Sorted[0]};

        while (i < a1Sorted.length && j >= 0 ) {
            int v1 = a1Sorted[i];
            int v2 = a2Sorted[j];
            int currentDiff = v1 + v2 - target;
            if (Math.abs(currentDiff) < smallestDiff) {
                smallestDiff = Math.abs(currentDiff);
                closestPair[0] = v1; closestPair[1] = v2;
            }

            if (currentDiff == 0) {
                return closestPair;
            }
            else if (currentDiff < 0) {
                i += 1;
            }
            else {
                j -= 1;
            }
        }

        return closestPair;
    }




    public static void main(String[] args) {
        int[] a = {2, 4,7, -5, 18,54, 38};
        int[] b  =  {7,-3,9,-22,7,46,10,98,26,-11};
        int target = 18;
        int[] solution = findClosestPair(a,b, target);
        for (int i: solution
             ) {
            System.out.println(i);
        }
    }
}
