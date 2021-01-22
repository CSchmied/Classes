import java.util.Scanner;
import java.text.DecimalFormat;
/** 
* A program that reads the input given and prints out
the base edge, label, and height. 
*
* Project_04 
* @author Carlton Schmieder
* @version 2-8-19 
*/ 
public class PentagonalPyramidApp 
{
/** 
* A method that states all the different inputs and etc.
* @param args  
*/
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      String label = ""; 
      double baseEdge = 0; 
      double height = 0; 
      double surfaceArea = 0;
      double volume = 0;  
      DecimalFormat df = new DecimalFormat("#,##0.0######");
       
      System.out.println("Enter label, base edge, and" 
         + " height for a pentagonal pyramid.");
      System.out.print("\tlabel: ");
      label = userInput.nextLine();
      System.out.print("\tbase edge: ");
      baseEdge = userInput.nextDouble(); 
      //If the base edge is less than zero, then the program will
      // state that error message and end.  
      if (baseEdge <= 0) {
         System.out.println("Error: base edge must be greater than 0."); 
      }
      // If the base edge is greater than zero, then the program 
      //will continue running. 
      else {
         System.out.print("\theight: ");
         height = userInput.nextDouble(); 
         //If the height is also less than zero, the program will
         // print the error message and stop running. 
         if (height <= 0) {
            System.out.println("Error: height must be greater than 0."); 
         }
         // If the height is greater than zero, the program
         //will continue running. 
         // If both are greater than zero, then the values will be plugged in
         // and calculated. 
         else {
            surfaceArea = ((double) 5 / 4) * (Math.tan(Math.toRadians(54))) 
               * Math.pow(baseEdge, 2);
            surfaceArea = surfaceArea + (5 * (baseEdge / 2)) 
               * (Math.sqrt(Math.pow(height, 2) 
               + Math.pow((baseEdge * Math.tan(Math.toRadians(54)) / 2), 2)));
               
            volume = ((double) 5 / 12) * (Math.tan(Math.toRadians(54)) 
               * (height) * (Math.pow(baseEdge, 2)));
           // If everything was entered correctly, the program will
           // print the statement out below. 
            System.out.println("");
            System.out.println("PentagonalPyramid \"" + label + "\" with base"
               + " edge = " + baseEdge + " and height = " 
                  + height + " units has:");
            System.out.println("\tsurface area = " + df.format(surfaceArea) 
               + " square units");
            System.out.println("\tvolume = " + df.format(volume) 
               + " cubic units");  
         }
      }
   } 
}