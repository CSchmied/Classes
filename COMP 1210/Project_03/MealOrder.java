import java.util.Scanner;
import java.text.DecimalFormat;
/** 
*Program to take the order code and print out the number of adult
meals and number of child meals. Then if it is over $100, it adds
in the 15% discount and prints name, meals, subtotal, discount, total and 
lucky number. If it is under $100 it prints out name, meals, 
total, and lucky number.
*
* Project_03
* @author - Carlton Schmieder
* @version 2-1-19
*/ 
public class MealOrder
{
   static final double DISCOUNT = 0.15;
   
   static final double DISCOUNT_THRESHOLD = 100.0;
   /** 
   * String where I put all the variables and equations to generate
   the total etc. 
   *
   * @param args Command line arguments - not used 
   */ 
   public static void main(String[] args) 
   { 
      Scanner userInput = new Scanner(System.in); 
      String order = "";
      int luckyNum = 0;  
      DecimalFormat df = new DecimalFormat("$#,##0.00");
      DecimalFormat df2 = new DecimalFormat("00000");
      //Where to insert the order number.  
      System.out.print("Enter your order code:    "); 
      order = userInput.nextLine().trim();
      if (order.length() >= 12) {
         System.out.println();
         order = order.trim(); 
         //Number of adult meals.
         int numAdultMeal = Integer.parseInt(order.substring(0, 2)); 
         //Price per adult meals.
         double priceAdultMeal = Double.parseDouble(order.substring(2, 6)) 
            / 100;
         //Number of child meals.
         int numChildMeal = Integer.parseInt(order.substring(6, 8)); 
         //Price per child meals.
         double priceChildMeal = Double.parseDouble(order.substring(8, 12)) 
            / 100;
         String name = order.substring(12);
         //Equation to find the total cost.
         double total = ((int) numAdultMeal * (double) priceAdultMeal) 
            + ((int) numChildMeal * (double) priceChildMeal);
         //If total is under $100, the program prints the total cost etc.
         if (total <= DISCOUNT_THRESHOLD) {
            System.out.println("Name: " + name);
            System.out.println("Adult meals: " + numAdultMeal + " at " 
               + df.format(priceAdultMeal)); 
            System.out.println("Child meals: " + numChildMeal + " at " 
               + df.format(priceChildMeal)); 
            System.out.println("Total: " + df.format(total));
            luckyNum = (int) (Math.random() * 99999) + 1;
            System.out.println("Lucky Number: " + df2.format(luckyNum));
         }
         // If total is over $100, the program prints the discount 
         //and calculates the total etc.
         else {
            System.out.println("Name: " + name);
            System.out.println("Adult meals: " + numAdultMeal + " at " 
               + df.format(priceAdultMeal)); 
            System.out.println("Child meals: " + numChildMeal + " at " 
               + df.format(priceChildMeal));
            System.out.println("Subtotal: " + df.format(total)); 
            double reduce = total * -DISCOUNT;
            System.out.println("15% Discount: " + df.format(reduce));
            double afterDiscount = total + reduce; 
            System.out.println("Total: " + df.format(afterDiscount));
            luckyNum = (int) (Math.random() * 99999) + 1; 
            System.out.println("Lucky Number: " + df2.format(luckyNum)); 
         }
      }
      // If code is not correct, the program prints this
      else {
         System.out.println("");
         System.out.println("Invalid Order Code.");
         System.out.println("Order code must have at least 12 characters.");
      }
       
         
      
   }
}