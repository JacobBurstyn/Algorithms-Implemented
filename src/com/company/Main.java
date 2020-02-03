package com.company;

//brute force of satisfiability


public class Main {


    boolean [] booleans;
    boolean expression;
    int numOfbools;
    boolean found;

    public Main(int variables){
        booleans =  new boolean[variables];
        numOfbools = variables;
        for (int i = 0; i < variables; i++) {
            booleans[i] = false;
        }
        expression = booleans[0] && booleans[1];
    }

    public void sat(){
        satisfiability(0);
    }
    public void satisfiability( int index){
        if(index>=numOfbools){
            if(evaluateExpression()){
                System.out.println("it is true ");
                found = true;
                return;
            }
            return;
        }
        booleans[index] = true;
        satisfiability(index+1);
        if(found){
            return;
        }
        booleans[index] = false;
        satisfiability(index+1);

    }

    private boolean evaluateExpression() {
        return booleans[0] && booleans[1];
    }

    public static void main(String[] args) {
	    Main m = new Main(2);
	    m.sat();
    }
}
