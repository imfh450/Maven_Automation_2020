package Action_Items;

public class Action_Item_DAY2 {
    public static void main(String[] args){

        //Declaring array variable for String and Int type
        String[] zipCode;
        int[] streetNumber;

        //Define String array and length.
        zipCode = new String[5];

        //Define the zipcode values on the array
        zipCode[0] = "11203";
        zipCode[1] = "11212";
        zipCode[2] = "11218";
        zipCode[3] = "12575";
        zipCode[4] = "23859";

        //Define the int and length
        streetNumber = new int[5];

        //Define the street number value
        streetNumber[0] = 457;
        streetNumber[1] = 3645;
        streetNumber[2] = 1333;
        streetNumber[3] = 1465;
        streetNumber[4] = 181;

        //For loop
        /*for(int i=0; i < zipCode.length; i++) {
            System.out.println("My zip code is " + zipCode[i] + " and my " +
                    "street number is " + streetNumber[i]);
        } */ //End of the for loop

        //While loop
        int i = 0;
        while(i < zipCode.length) {
            System.out.println("My zipcode is " + zipCode[i] + " and my street number is "
                    + streetNumber[i]);
            i++; // or you can use i=i+1;
        }//End of while loop

    }//End of main class

}//End of parent class

