package exercise2;

import java.util.ArrayList;

public class Colors {
    public static ArrayList<String> myList = new ArrayList<String>();
    String[] colorful(String[] strings) {
        for ( int i = 0; i<strings.length; i++ ) {
            String[] arr = strings[i].split(" ");
            if ( arr[0].equals("red") || arr[0].equals("yellow") || arr[0].equals("green") || arr[0].equals("black") || arr[0].equals("pink")) {
                myList.add(strings[i]);
            }
        }
        return strings;
    }

    public static void main(String[] args) {
        Colors code = new Colors();
        String[] colors = {"bluebird","red herring", "yellow bumblebee","black spider", "green monkey","pink","great gatsby","feeding frenzy","black bird","widowmaker","quran","bible","torah"};
        code.colorful(colors);


        System.out.println("This is the Colors class");
        for ( int i = 0; i<myList.size(); i++ ) {
            System.out.println(myList.get(i));
        }
    }


}