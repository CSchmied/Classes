import java.util.Scanner;
/**
* Program to calculate imperial distance.
*
* Project_02
* @author Carlton Schmieder
* @version 1-23-19
*/
public class ImperialDistance
{
   /**
   * Declaring int and assigning their values.
   * @param args Command line arguements - not used
   */
   public static void main(String[] args)
   {
   //Creating int that is going to be used. 
      Scanner userInput = new Scanner(System.in);
      int miles = 0;
      int yards = 0; 
      int feet = 0;
      int inches = 0;
      int distance = 0;  
   
   //Prompt to enter distance measurement.
      System.out.print("Enter the raw distance measurement in inches: ");
      distance = userInput.nextInt();
      //If distance enter is negative, this prompt prints.
      if (distance < 0) {
         System.out.println("Measurement must be non-negative!"); }
      //If distance entered is positive, this prompt prints. 
      else {
         System.out.println("");
         System.out.println("Measurement by combined miles, yards, "
            +  "feet, inches: ");
      //Program that calulates inches in miles. 
         System.out.println("\tmiles: " + (int) distance / 63360);
      //Prompt that calculates inches in yards.
         System.out.println("\tyards: " + (int) distance % 63360 / 36);
      //Prompt that calculates inches in feet
         System.out.println("\tfeet: " + (int) distance % 63360 % 36 / 12);
      //Prompt that calculates inches
         System.out.println("\tinches: " + (int) distance % 63360 % 36 % 12); 
         System.out.println("");
      //Prompt that states the calculations in one line. 
         System.out.println((int) distance + " in = " 
            + (int) distance / 63360 + " mi, " 
            + (int) distance % 63360 / 36 + " yd, "
            + (int) distance % 63360 % 36 / 12 
            + " ft, " + (int) distance % 63360 % 36 % 12 + " in");
      }
   }
}