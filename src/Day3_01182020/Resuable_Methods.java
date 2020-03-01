package Day3_01182020;

public class Resuable_Methods {

    //Void method add two variables and print the result
    public static void addVoid(int a,int b){

        System.out.println("My result is " + (a+b));
    }//End of addvoid1

    //Void method to add two variables and print the result
    public static void addVoid(int arg1, int arg2, int arg3){
        System.out.println("My reslut is " + (arg1+arg2+arg3));
    }//end of addvoid2

    //return method to add two variable and return the result
    public static int addReturn(int a, int b){
        int c = a+b;
        System.out.println("My result is " + c);

        return c;
    }//End of return method

}
