package exercise2;

class Types {

    //    This class has syntax errors, that will prevent your other classes from running.  So... work on this file first to resolve the issues.
    static boolean number;
    static int[] myArray = {3,4,5,6,76,12,2};
    static String movieA = "Harry and the Hendersons";
    static String movieB = "Star Wars";
    static char male = 'm';
    static char female = 'f';
    //
//    the above instance variables have mistakes with their data types.  Fix the data types so the main method correctly displays the value of all of the variables
//
    public static void main(String[] args) {
        System.out.println("There are variables that have been declared in this Accessible class.  Fix the code so that all the variables can be accessed by the main method.  print out the values of every variable once the code has been refactored.");

        // number
        //  this.number = true;

        // printing myArray values:
        for ( int i = 0; i<myArray.length; i++ ) {
            System.out.println(myArray[i]);
        }

        // printing movieA and movieB
        System.out.println("I just watched 2 movies, they are " + movieA + " and " + movieB);

        // pringing char values
        System.out.println(male + " stands for male and " + female + " stands dor female");
    }

}