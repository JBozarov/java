package exercise2;

public class Statically {
    private static String glue = "Epoxy";
    String jello = "Jello";

    // in order to call methods of the class I created main method:
    public static void main(String[] args) {

        // to call non static method I need to create instance of the class
        Statically s = new Statically();
        s.moveAndShake();

        // Calling static methods
        stubborn();
        explain();

    }

    // this is public method
    public void moveAndShake() {
        System.out.println("Never stagnate in life.  Be agile, change, and improve...");
    }

    // static method return type is void we are just printing only
    public static void stubborn() {
        Statically s2 = new Statically();
        s2.moveAndShake();
        System.out.println("Please don't make me change... I just don't like it...");
    }



    public static void explain(){
        stubborn();
        System.out.println(glue);
        System.out.println("Explanations: ");
        System.out.println("1. Well first I created main method inside a class Statically class because I know there must be main method in each project in order to run our code ");
        System.out.println("2. For non static method I created instane of class using default constructor and then I invoked the method using instance of class that I just created");
        System.out.println("3. For static methods, in order to invoke them, I did not have to create instate of class I just invoked directly from main method ");
    }
}
