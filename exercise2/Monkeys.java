package exercise2;

class Monkeys {

    boolean monkeyBusiness(Monkey[] monkeys) {
        //BONUS EXERCISE
        //We have a set of monkeys.  Each Monkey has a boolean smile property, which indicates if that particular monkey is smiling.  Determine whether or not the majority of monkeys are smiling.  If the majority are smiling, return true.  if the majority are not smiling, return false.  If it is a tie, return true.
        return true;
    }

    static class Monkey {
        String name;
        boolean smile;

        public Monkey(String name, boolean smile) {
            this.name = name;
            this.smile = smile;
        }
    }




    public static void main(String[] args) {
        //Bonus exercise instructions:  create an array of at least 3 monkeys, utilizing the nested Monkey class, and determine whether the majority of them are smiling or not.
        // required monkey data:
        // Rafiqi is smiling
        // Curious George is smiling
        // King Kong is not smiling
        //You are NOT allowed to move the Monkey class.  Keep it where it is.

        Monkey m1 = new Monkey("Rafiqi", false);
        Monkey m2 = new Monkey("Curious George", true);
        Monkey m3 = new Monkey("King Kong", false);
        Monkey m4 = new Monkey("Shampanzee", true);
        Monkey m5 = new Monkey("Small monkey", true);

        Monkey[] monkeyList = {m1, m2, m3, m4, m5};
        int smiling = 0;
        int notSmiling = 0;

        for (int i = 0; i<monkeyList.length; i++ ) {
            if (monkeyList[i].smile) {
                smiling++;
                System.out.println(monkeyList[i].name + " is smiling ");
            }
            else {
                notSmiling++;
                System.out.println(monkeyList[i].name + " is NOT smiling ");
            }
        }

        // Printing if smiling or not smiling monkeys are more or they are equal
        if (smiling>notSmiling) {
            System.out.println("Smiling monkeys are more ");
        } else if (smiling<notSmiling) {
            System.out.println("Not smiling monkeys are more ");
        } else {
            System.out.println("Smiling and not smiling monkeys are equal");
        }

    }


}