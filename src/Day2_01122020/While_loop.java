package Day2_01122020;

public class While_loop {
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

        //using while loop to iterate through series of zip code
        int i = 0;
        while ( i<5){
            System.out.println("My zipcode is " + zipcode[i]);

            i++;

        }//end of 1st while loop

        int j = 0;;
        //using length of the array
        while (j<zipcode.length) {
            System.out.println("My zipcode is " + zipcode[j]);

            j++;
        }//end of 2nd while loop

    }//end of main class

}//end of parent class
