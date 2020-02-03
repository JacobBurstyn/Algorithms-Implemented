package com.company;

public class Uni2{


    public static int numDecodings(String s) {
        int[] memo = new int[s.length()+1];
        return helper(s,s.length(),memo);
    }

    public static int helper(String s, int length, int[] memo){


        if(length==0){
            return 1;
        }
        if(s.charAt(s.length()-length)=='0'){
            return 0;
        }

        // if(memo[length]!=0){
        //     return memo[length];
        // }
        int num = helper(s,length-1, memo);
        if(length-2>=0){
            if(Integer.parseInt(s.substring(s.length()-length, (s.length()-length)+2))<=26){
                num += helper(s,length-2, memo);
            }
        }
        //memo[length] = num;
        return num;
    }

    public static int subsets(int[] set){
        int[] which = new int[set.length];
        int i = helper2(set, 0, which);
        return i;
    }

    public static int helper2(int[] set, int num, int[] which){
        if(num==which.length){System.out.println("new set");
            for (int i = 0; i < which.length ; i++) {

                if(which[i]==1){
                    System.out.print(set[i]+", ");
                }
            }
            System.out.println("");
            return 1;
        }
        which[num] = 0;
        int j = helper2(set,num+1,which);
        which[num] = 1;
        int k = helper2(set,num+1,which);
        return k+j;
    }
    public static void itsubset(int[] set) {
        int i = set.length;
        i = 1 << i;
        for (int j = 0; j < i; j++) {

            for (int k = 0; k < set.length; k++) {
                int p = 1 << k;
                int a = j & p;
                if (a > 0) {
                    System.out.print(set[k]);
                }
            }
            System.out.println();

        }


    }
    class node {
        node pointer;
        int value;
    }
        public static void add(node n, node start){
            node  next = start.pointer;
            node prev = start;


        }
        public void getAddress(int pointer){

        }



    public static void main(String[] args) {
        //System.out.println(numDecodings("10"));
        //System.out.println(subsets(new int[]{3,5,7}));
        itsubset(new int[]{3,5,7});
    }

}


