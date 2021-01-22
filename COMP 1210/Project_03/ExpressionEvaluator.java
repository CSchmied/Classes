import java.util.Scanner;
import java.text.DecimalFormat; 
/** 
* Program that solves a given equation with the
variables inserted x, y, and z values. 
*
* Project_03
* @author Carlton Schmieder
* @version 2-1-19 
*
*/

public class ExpressionEvaluator 
{
/**
* String that includes all the variables and Scanner tools.
* @param args Command Line arguments - not used
*/
   public static void main(String[] args) 
   {
      Scanner userInput = new Scanner(System.in); 
      double x = 0; 
      double value = 0; 
      DecimalFormat df = new DecimalFormat("#,##0.0###");
      Double.toString(value);
      System.out.print("Enter a value for x: "); 
      x = userInput.nextDouble(); 
      //If x is greater than zero, the value will equal the value below.
      if (x >= 0) {
         value = Math.sqrt(Math.abs(1.2 * Math.pow(x, 3) - 10 * x + 1) 
            + Math.pow(5 * Math.pow(x, 4) - 7 * Math.pow(x, 3), 2)) 
            / (Math.pow(x, 2) + 10);
      } 
      //If x is less than zero, the value will equal the value below.
      else {
         value = Math.sqrt(Math.abs(1.2 * Math.pow(x, 3) - 10 * x + 1) 
            + Math.pow(5 * Math.pow(x, 4) - 7 * Math.pow(x, 3), 2)) 
            / (Math.pow(x, 2) + 10);
      }
      //Prints the result out
      System.out.println("Result: "
         + (double) value + "");
      String newResult = Double.toString(value);
      int left = newResult.indexOf("."); 
      int total = newResult.length(); 
      int right = total - left - 1;  
      //Calulates the number of decimal points from the left and right 
      System.out.println("# of characters to left of decimal point: " + left);
      
      System.out.println("# of characters to right of decimal point: " 
         + right); 
      //Prints the formatted result out
      System.out.println("Formatted Result: " + df.format(value));
      
   }
}
