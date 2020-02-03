package com.company;



//class Newton  {
//    //beale function
//
//
//    public static void main(String argv[]) {
//
//        double tolerance = .000000001; // Our approximation of zero
//        int max_count = 200; // Maximum number of Newton's method iterations
//
////  start at 0 and 0 for x and y
//
//        double x = 0;
//        double y =0;
//
//        if(argv.length==1) {
//            x= Double.valueOf(argv[0]).doubleValue();
//        }
//
//        for( int count=1;
//             (Math.abs(f(x,y)) > tolerance) && ( count < max_count);
//             count ++)  {
//            x= x - f(x,y)/fprime(x,y);
//            System.out.println("Step: "+count+" x:"+x+" Value:"+ "y "+ y+f(x,y));
//        }
//
//        if( Math.abs(f(x,y)) <= tolerance) {
//            System.out.println("Zero found at x="+x+ "y "+ y);
//        }
//        else {
//            System.out.println("Failed to find a zero");
//        }
//    }
//
//}