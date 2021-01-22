import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
/** 
* A program that uses PentagonalPyramid and
PentagonalPyramidalList to print out the calculations.
*
* Project_05
* @author Carlton Schmieder
* @version 2-21-19 
*/ 

public class PentagonalPyramidListApp
{
/** 
* Main method that takes the information
through the project and prints a statement out.
* @param args not used
* @throws FileNotFoundException   
*/ 
   public static void main(String[] args) throws FileNotFoundException
   {
      ArrayList<PentagonalPyramid> list = new ArrayList<PentagonalPyramid>(); 
   
      Scanner scan = new Scanner(System.in);
      System.out.print("Enter file name: "); 
      String fileName = scan.nextLine(); 
   
      Scanner scanFile = new Scanner(new File(fileName));
      
      String pentList = scanFile.nextLine(); 
      
      while (scanFile.hasNext()) {
         String label = scanFile.nextLine().trim(); 
         double baseEdge = Double.parseDouble(scanFile.nextLine()); 
         double height = Double.parseDouble(scanFile.nextLine()); 
        
         PentagonalPyramid p = new PentagonalPyramid(label, baseEdge,
            height);
         list.add(p);
      } 
      scanFile.close(); 
      
      PentagonalPyramidList myList = new PentagonalPyramidList(pentList, 
         list); 
         
      System.out.println("\n" + myList);
      
      System.out.println("\n" + myList.summaryInfo()); 
       
   
   
   }  

}