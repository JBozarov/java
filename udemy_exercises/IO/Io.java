package udemy_exercises.IO;

import java.util.Scanner;

public class Io {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please fill out the Application form");
        System.out.println("Please enter first name:");
        String firstName = scanner.nextLine();
        System.out.println("Please enter your last name:");
        String lastName = scanner.nextLine();
        System.out.println("Please enter your email address:");
        String email = scanner.nextLine();
        System.out.println("Please enter your data of birth:");
        String dob = scanner.nextLine();

        System.out.println("Your name is: " + firstName + " " + lastName);
        System.out.println("and you are born one: " + dob + " and your email is " + email);

    }
}
