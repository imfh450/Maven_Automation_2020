package Day2_01122020;

public class Dynamic_Array {
    public static void main(String[] args){

        //declaring array variable for String and Int type
        String[] zipcode;
        int[] streetNumber;

        //define string array and length
        zipcode = new String[5];

        //define the zipcode values on the array
        zipcode[0] = "11218";
        zipcode[1] = "11219";
        zipcode[2] = "11021";
        zipcode[4] = "22212";

        //printing zipcode
        System.out.println("This zipcode is " + zipcode[3]);
        System.out.println("My zipcode is near " + zipcode[0]);

        streetNumber = new int[5];
        streetNumber[0] = 221;
        streetNumber[1] = 515;
        streetNumber[2] = 919;
        streetNumber[4] = 1221;

        //printing streetNumber
        System.out.println("This street number is " + streetNumber[3]);
        System.out.println("My street number is " + streetNumber[4]);






    }//end of the main

}//end of the parent class