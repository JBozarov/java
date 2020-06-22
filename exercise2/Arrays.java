package com.exercise2;



class Arrays {
    //Take the arrays.js file, and refactor the code into Java in this file.
    int[] nums = {10,23,3,4,5,2,1};
    String[] greetings = {"hello","howdy","hallo","hola","bonjour","ciao","أهلا"};
    boolean[] binaries = {false, true, true, true, false, false, false, true, true, true, true, false, true, false, false, true, false};

    void printNums() {
        for ( int i = 0; i<nums.length; i++ ) {
            System.out.println("Number values are: " + nums[i]);
        }
    };


    void printGreetings() {
        for (int k = 0; k<greetings.length; k++ ) {
            System.out.println("String values are: " + greetings[k]);
        }
    };
    void printBinaries() {
        for ( int m = 0; m<binaries.length; m++ ) {
            System.out.println("Boolean values are: " + binaries[m]);
        }
    };
}







