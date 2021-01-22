import java.util.Scanner;
/** 
* Program to solve the equation below.
*
* Project 02
* @author Carlton Schmieder
* @version 1-25-19
*/
public class Solver
{
/**
* String that includes the set variables etc.
* @param args Command line arguments
*/
   public static void main(String[] args)
   {
      Scanner userInput = new Scanner(System.in);
      double x = 0;
      double y = 0;
      double z = 0;
      double result = 0;
      //Prompt to show the result formula
      System.out.println("result = (10x + 4.1) (5y + 8.7) / z");
      //Prompt to enter x value:
      System.out.print("\tEnter x: ");
      x = userInput.nextDouble();
      //Prompt to enter y value:
      System.out.print("\tEnter y: ");
      y = userInput.nextDouble();
      //Prompt to enter z value:
      System.out.print("\tEnter z: ");
      z = userInput.nextDouble(); 
      if (z == 0) {
         result = 0;
      }
      else {
         result = (10 * x + 4.1) * (5 * y + 8.7) / z;
      } 
      //Prompt to show result
      System.out.print("result = "
         + (double) result + "");
         
   } 
   
}