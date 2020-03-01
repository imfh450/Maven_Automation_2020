package Day4_01192020;

public class Conditions_operators {
    public static void main (String[] args){
        String[] fruits;
        fruits = new String [4];
        fruits[0] = "Apple";
        fruits[1] = "Orange";
        fruits[2] = "Strawberry";
        fruits[3] = "Grape";

        //iterate through the value and only print when the i is apple or grape
        //integer variable only can  use == and only can use numeric operators such as <,>,<=,>= etc
        for (int i = 0 ; i <fruits.length; i++){
            if (fruits [i].equalsIgnoreCase("apple")) {
                System.out.println("My Fruit is " + fruits[i]);

            } else if (fruits[i] == "Grape"){
                System.out.println("My fruit is " + fruits[i]);
            }
            if (fruits[i] == "Apple" || fruits[i] == "Grape"){
                System.out.println("My Fruit is "+fruits[i]);
            }
        }//End of for loop

    }//End of main class
}//End of parent calss
