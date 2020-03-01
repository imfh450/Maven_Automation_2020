package Action_Items;

public class act {
    public static void main(String[] args) {

        //declaring array variable for String and Int type
        String[] zipcode;
        int[] streetNumber;

        //define string array and length
        zipcode = new String[5];

        //define the zipcode values on the array
        zipcode[0] = "11218";
        zipcode[1] = "11219";
        zipcode[2] = "11021";
        zipcode[3] = null;
        zipcode[4] = "22212";


        //define the int and length
        streetNumber = new int[5];

        //define the street number value
        streetNumber[0] = 221;
        streetNumber[1] = 515;
        streetNumber[2] = 919;
        streetNumber[3] = 0;
        streetNumber[4] = 1221;


        //action item


        //For loop
        for (int i = 0; i < zipcode.length; i++) {

            System.out.println("My zip code is " + zipcode[i] + " and my street number is " + streetNumber[i]);
        }
    }
}
