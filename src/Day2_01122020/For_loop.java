package Day2_01122020;

public class For_loop {
    public static void main(String[] args){

        //declare zipcode
        String[] zipcode;
        //define string array and length
        zipcode = new String[5];

        //define the zipcode values on the array
        zipcode[0] = "11218";
        zipcode[1] = "11219";
        zipcode[2] = "11021";
        zipcode[4] = "22212";

        //using for loop to iterate through series of zip code
        for(int i=0; i<5; i++){
            System.out.println("My zipcode is " + zipcode[i]);
        }//end of for loop

        //using length of the array
        for(int i=0; i<zipcode.length; i++)
            System.out.println("My zipcode is " + zipcode[i]);





    }//end of the  main

}//end of the parent class

