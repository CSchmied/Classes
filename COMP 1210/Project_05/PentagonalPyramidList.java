import java.util.ArrayList; 
import java.text.DecimalFormat;

/**  
* A program that stores the name of the list and an
ArrayList and returns summary information. 
*
* Project_05
* @author Carlton Schmieder
* @version 1-20-19 
*/ 

public class PentagonalPyramidList 
{
//Fields    
   private String listName = ""; 
   private ArrayList<PentagonalPyramid> objects; 
   
 // Constructor 
 /** 
 * Constructor including all given instance variables.
 * @param listNameIn  
 * @param objectsIn  
 */
   public PentagonalPyramidList(String listNameIn, 
      ArrayList<PentagonalPyramid> objectsIn) { 
      listName = listNameIn;
      objects = objectsIn;
   
   }
     
  // Methods 
  /** 
  * @return listName from the get. 
  */ 
   public String getName() {
      return listName; 
   } 
   
   /** 
   * @return objects.size() which is the number of 
   pentagonal pyramids. 
   */ 
   public int numberOfPentagonalPyramids() {
      return objects.size(); 
   }
    
    /** 
    * @return totalSA caluclated from the surface
    area formula. 
    */  
   public double totalSurfaceArea() {
      double totalSA = 0;
      int index = 0; 
      while (index < objects.size()) {
         totalSA += objects.get(index).surfaceArea();  
         index++;
      }
      return totalSA; 
   }
   
   /** 
   * @return totalV which is the total volume of
   all pyramids. 
   */
   public double totalVolume() {
      double totalV = 0; 
      int index = 0; 
      while (index < objects.size()) {
         totalV += objects.get(index).volume(); 
         index++;
      }
      return totalV;
   }
   
   /** 
   * @return the average surface area. 
   */ 
   public double averageSurfaceArea() {
      double aveSA = 0; 
      int index = 0; 
      if (objects.size() > 0) { 
         while (index < objects.size()) { 
            aveSA = totalSurfaceArea() / objects.size(); 
            index++;
         } 
         return aveSA;
      } 
      else {
         return 0; 
      } 
   }
  
  /** 
  * @return average volume of all pyramids. 
  */ 
   public double averageVolume() {
      double aveV = 0; 
      int index = 0; 
      if (objects.size() > 0) {
         while (index < objects.size()) {
            aveV = totalVolume() / objects.size(); 
            index++;
         }
         return aveV;
      }
      else { 
         return 0; 
      }
   }  
   
   /** 
   * @return Result of the string.
   */
   public String toString() { 
      String result = listName + "\n";
      int index = 0; 
      while (index < objects.size()) { 
         result += "\n" + objects.get(index); 
         index++; 
      } 
      return result; 
   }
   
   /** 
   * @return String with the summary information.
   */
   public String summaryInfo() {
      DecimalFormat df = new DecimalFormat("#,##0.0##"); 
      String result = "";
      result += "----- Summary for " + listName + " -----\n"; 
      result += "Number of PentagonalPyramid: " 
         + numberOfPentagonalPyramids() + "\n"; 
      result += "Total Surface Area: " + df.format(totalSurfaceArea()) + "\n"; 
      result += "Total Volume: " + df.format(totalVolume()) + "\n";
      result += "Average Surface Area: " + df.format(averageSurfaceArea()) 
         + "\n";
      result += "Average Volume: " + df.format(averageVolume()) + "\n"; 
   
      return result; 
   }
         
}